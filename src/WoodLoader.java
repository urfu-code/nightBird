import java.io.InputStream;

/**
 * ��������� ����
 */
public interface WoodLoader {
	/**
	 * ������� ��������� ���� �� ������ �� ������.
	 * @param stream ����� � ����������� � ����.
	 * @return ���
	 */
	MyWood Load(InputStream stream);
}
