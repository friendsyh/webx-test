package tim.test.login.common;
import java.security.Key;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

//ECB模式  DES加密、解密算法
public class DesECBencrypt {
    /** 
     * 加密数据 
     * @param encryptString  注意：这里的数据长度只能为8的倍数 
     * @param encryptKey 
     * @return 
     * @throws Exception 
     */  
    public static byte[] encryptDES(byte[] encryptbyte, byte[] encryptKey) throws Exception { 
    	System.out.println(encryptbyte.length + ":" + encryptKey.length);
        SecretKeySpec key = new SecretKeySpec(getKey(encryptKey), "DES");  
        Cipher cipher = Cipher.getInstance("DES/ECB/NoPadding");  
        cipher.init(Cipher.ENCRYPT_MODE, key);  
        byte[] encryptedData = cipher.doFinal(encryptbyte);  
        return encryptedData;
    }  
    
  //进行ECB模式的DES加密，已验证成功
  	 public static void main(String[] args) throws Exception {
  		 //DES加密（ECB模式）
  		 String str = "0123456789ABCDEF";
  		 System.out.println("原数据："+str);
  		 byte[] s = encryptDES(PBOCDESConvertUtil.hexStringToByte(str),PBOCDESConvertUtil.hexStringToByte("3A3DAA526E0D4C43B69D7DEAC47F80AF68814BEA5E7F26BA"));
  		 System.out.println("加密结果："+ Arrays.toString(s));
  		 //DES解密
//  		 System.out.println("解密结果："+DES.bytesToHex(decryptDES2(DES.bytesToHex(s), PBOCDESConvertUtil.hexStringToByte("1111111111111111"))));
  	}
  	 
	 
      
    /** 
     * 自定义一个key 
     * @param string  
     */  
    public static byte[] getKey(byte[] keyRule) {  
        Key key = null;  
        byte[] keyByte = keyRule;  
        // 创建一个空的八位数组,默认情况下为0  
        byte[] byteTemp = new byte[8];  
        // 将用户指定的规则转换成八位数组  
        for (int i = 0; i < byteTemp.length && i < keyByte.length; i++) {  
            byteTemp[i] = keyByte[i];  
        }  
        key = new SecretKeySpec(byteTemp, "DES");  
        return key.getEncoded();  
    }  
      
    /*** 
     * 解密数据 
     * @param decryptString 
     * @param decryptKey 
     * @return 
     * @throws Exception 
     */  
    public static byte[] decryptDES2(String decryptString, byte[] decryptKey) throws Exception {  
        SecretKeySpec key = new SecretKeySpec(getKey(decryptKey), "DES");  
        Cipher cipher = Cipher.getInstance("DES/ECB/NoPadding");  
        cipher.init(Cipher.DECRYPT_MODE, key);  
        byte decryptedData[] = cipher.doFinal(PBOCDESConvertUtil.hexStringToByte(decryptString));  
        return decryptedData;  
    }  
      
}