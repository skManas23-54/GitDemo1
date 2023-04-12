import org.apache.commons.codec.binary.Base64;

public class EncodeData {
    public static void main(String[] args) {
        String str="test123";
        byte[]encodeString= Base64.encodeBase64(str.getBytes());
        System.out.println(new String(encodeString));
    }
}
