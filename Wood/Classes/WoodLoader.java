package Classes;

import java.io.*;
import java.util.LinkedList;

import Exceptions.EmptyFileException;
import Exceptions.InvalidFileException;
import Interfaces.WoodInterface;


public class WoodLoader implements Interfaces.WoodLoaderInterface {

	@Override
	public WoodInterface Load(InputStream stream) throws EmptyFileException, InvalidFileException{
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
			try {
				//читаем из файла и создаем объект Wood
				return new Wood(readArray(reader)); 
			} finally {
				reader.close();
			}
		} 
		catch (EmptyFileException e) {
			throw e;
		}
		catch (IOException e) {
			System.out.println("EXCEPTION: " + e.getMessage());
			e.printStackTrace();
		}
		//Если вдруг что-то пошло не так - возвращаем null
		//хотя сюда он никогда не дойдет: либо обвалится с исключением, либо сработает return
		return null;
	}

	private static char[][] readArray(BufferedReader reader) throws IOException, InvalidFileException {
		String newLine = reader.readLine();
		if (newLine == null)
			throw new EmptyFileException("Пустой файл");
		//будем использовать LinkedList, тк мы не знаем, сколько всего будет строчек, а здесь добавление всегда за О(1)
		LinkedList<char[]> array = new LinkedList<char[]>();
		int len = newLine.length();
		//Индексуем номера строк с 0
		int line = 0;
		while (newLine != null) {
			if (newLine.length() != len)
				throw new InvalidFileException("Длина первой строки: " + len + ". А длина " + line + " строки: " + newLine);
			//Добавляем в конец массива (индекс = номеру строки) новый массив
			array.add(newLine.toCharArray());
			newLine = reader.readLine();
		}
		//Преобразуем LinkedList из char[] в char[][]
		//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		char[][] mas = (char[][]) array.toArray(new char[line][len]);
		//У полученного массива поменены местами ось Х и Y
		//Так что создаем новый массив и транспонируем в него исходный
		char[][] newMas = new char[mas[0].length][mas.length];
		for (int i=0; i< mas.length; i++)
			for (int j=0; j<mas[0].length; j++) {
				newMas[j][i]=mas[i][j];
			}
		
		//System.out.println(newMas.length + " " + newMas[0].length);
		return newMas;
	}
}
