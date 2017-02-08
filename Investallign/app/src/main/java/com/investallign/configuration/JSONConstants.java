package com.investallign.configuration;

public class JSONConstants {

    /* JSON Constants Used in Application */

    /* Common String */

    public static final String HTTP_200 = "200";
    public static final String CODE = "code";
    public static final String MESSAGE = "message";
    public static final String STATUS = "status";
    public static final String KEY = "key";

    private JSONConstants() {
    }

    public class GetPage {

        // Request
        public static final String TEST_CONNECTION = "Test_Connection";
        public static final String REQUEST_PAGE = "page";
        // Response

        public static final String RESPOSE_PAGE_CONTENT = "page_content";
        public static final String RESPOSE_PAGE_ID = "page_id";
        public static final String RESPOSE_PAGE_TITLE = "page_title";
        public static final String RESPONSE_DATA = "data";


        protected GetPage() {
        }
    }


}
