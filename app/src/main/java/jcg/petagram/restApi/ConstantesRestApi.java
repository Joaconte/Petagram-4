package jcg.petagram.restApi;

public final class ConstantesRestApi {

    public static final String VERSION                      = "/v8.0/";
    public static final String ROOT_URL                     = "https://graph.facebook.com" + VERSION;
    public static final String KEY_ACCESS_TOKEN             = "&access_token=";
    public static final String ACCES_TOKEN                  = "EAAjrSfsou8kBABFqSjs4vxnn9x5mZCDD59WtuQqbQcRuXUMm4MVtlcUXZAUmntlsszsdOEhKPjtKiCBxZAdxbZAevpWpSGQJ23QvIjcxm8amj6td3ZC1WNGGe7PHYPoUPUXtJap2B81sYV9Ar3ZCTPhq9bpeV4itVY9VeZCBBi2LgZDZD";

    public static final String USER_ID                      = "17841444360312829";
    public static final String KEY_GET_MEDIA_USER           = USER_ID + "/media?fields=ig_id,username,like_count,media_url";
    public static final String URL_GET_MEDIA_USER           = ROOT_URL + KEY_GET_MEDIA_USER + KEY_ACCESS_TOKEN + ACCES_TOKEN ;

    public static final String KEY_GET_INFORMATION_USER     = USER_ID + "?fields=profile_picture_url,username";
    public static final String URL_GET_INFORMATION_USER     = ROOT_URL + KEY_GET_INFORMATION_USER + KEY_ACCESS_TOKEN + ACCES_TOKEN ;


}
