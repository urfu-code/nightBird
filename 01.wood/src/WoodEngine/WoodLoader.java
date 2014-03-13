package WoodEngine;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Vector;


public class WoodLoader implements IWoodLoader {
	
	@Override
	public IWood Load(InputStream stream) throws IOException {
		InputStreamReader rdr = new InputStreamReader(stream, "utf-8");
		Vector<Character> vec = new Vector<Character>();
		int h = 0;
		int w = 0;
		int v;
		try{
			while((v = rdr.read()) >= 0){
				vec.add((char)v);
			}
		}
		finally{
			rdr.close();
		}
		if(System.lineSeparator().length() == 2){
			// \r\n
			w = vec.indexOf('\r');
			h = (vec.size() + 2) / (w + 2);
			if(w * h != (vec.size() - (h-1)*2)){
				throw new IOException("Not orthogonal");
			}
			for (int i = 0; i < h - 1; i++) {
				vec.removeElement('\r');
				vec.removeElement('\n');
			}
		}
		else{
			// \n
			w = vec.indexOf('\n');
			h = (vec.size() + 1) / (w + 1);
			if(w * h != (vec.size() - (h-1))){
				throw new IOException("Not orthogonal");
			}
			for (int i = 0; i < h - 1; i++) {
				vec.removeElement('\n');
			}
		}
		for (Iterator<Character> iterator = vec.iterator(); iterator.hasNext();) {
			Character ch = (Character) iterator.next();
			if ((ch != '0') && (ch != '1') && (ch != '2') && (ch != '3')) {
				throw new IOException("Too odd input");
			}
		}
		Character[] a = new Character[vec.size()];
		vec.toArray(a);
		return new Wood(a, h, w);
	}

}
