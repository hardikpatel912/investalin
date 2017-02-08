package com.investallign.managers;


import org.json.JSONException;


public class ParseManager {
    /* Parse Json String According to Request Type and Return Object */
    private static Object parsedObject = null;

    private ParseManager() {
    }

//    public static Object parse(RequestType requestType, String json)
//            throws JSONException {
//        switch (requestType) {
//            case GET_PAGE:
//            parsedObject = KhelMahaKumbhParseManager.parseAboutusDetails(json);
//            break;
//            case GET_FAQ:
//                parsedObject = KhelMahaKumbhParseManager.parsefaqsDetails(json);
//                break;
//            case GET_STATISTICS:
//                parsedObject = KhelMahaKumbhParseManager.parseStatisticsDetails(json);
//                break;
//
//        default:
//            break;
//        }
//        return parsedObject;
//    }


}
