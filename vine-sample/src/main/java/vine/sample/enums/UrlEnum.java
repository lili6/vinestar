package vine.sample.enums;

/**
 * Created by liguofang on 2014/10/28.
 */
public class UrlEnum {

    enum URL{
        HOST( "www.google.com" ),
        CAPTCHA( "/logo.jpg" ),
        ACTION_0( "/promotion.html?locale=en_GB" ),
        ACTION_1( "/agreement.html" ),
        ACTION_2( "/authkey.html" ),
        ACTION_3( "/contactinfo.html" ),
        ACTION_4( "/accountname.html" ),
        ACTION_5( "/verify.html" ),
        ACTION_6( "/completed.html" );
        String value;
        URL( String value )	{
            this.value = value;
        }
    }
    public static void main(String args[]) {
     System.out.print(URL.HOST);

    }

}
