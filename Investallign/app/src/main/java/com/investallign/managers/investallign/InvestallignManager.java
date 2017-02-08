package com.investallign.managers.investallign;

public class InvestallignManager {


    private static final InvestallignManager INSTANCE = new InvestallignManager();
    private static final String TAG = InvestallignManager.class.getSimpleName();

    private InvestallignManager() {
    }

    public static InvestallignManager getInstance() {
        return INSTANCE;
    }

    public void init() {
//        Logger.printLog(LoggerConstants.KHEL_MAHAKUMBH_MANAGER, "INIT khelmahakumbh MANAGER");
    }


//    public void getPageDetails(final Context context, String url,
//                               final ResponseListener listener,
//                               RequestBody requestBody) {
//
//        ParseListener parseListener = new ParseListener() {
//
//            @Override
//            public Object onParse(String jsonString) {
//                PageDetailKhelmahakumbhResponseEntity pageDetailKhelmahakumbhResponseEntity = null;
//                try {
//                    pageDetailKhelmahakumbhResponseEntity = (PageDetailKhelmahakumbhResponseEntity) ParseManager
//                            .parse(RequestType.GET_PAGE, jsonString);
//                } catch (JSONException e) {
//
//                    pageDetailKhelmahakumbhResponseEntity = new PageDetailKhelmahakumbhResponseEntity();
//                    Log.e(TAG, e.toString(), e);
//                } catch (Exception e) {
//
//                    pageDetailKhelmahakumbhResponseEntity = new PageDetailKhelmahakumbhResponseEntity();
//                    Log.e(TAG, e.toString(), e);
//                }
//                return pageDetailKhelmahakumbhResponseEntity;
//            }
//        };
//
//
//        new AsyncTaskForNetworkManager(context, url,
//                parseListener, requestBody) {
//
//            @Override
//            protected void onPostExecute(Object object) {
//
//                super.onPostExecute(object);
//                try {
//                    PageDetailKhelmahakumbhResponseEntity pageDetailKhelmahakumbhResponseEntity = (PageDetailKhelmahakumbhResponseEntity) object;
//                    listener.onResponse(pageDetailKhelmahakumbhResponseEntity);
//                } catch (Exception e) {
//                    Log.e(TAG, e.toString(), e);
//                    listener.onResponse(new PageDetailKhelmahakumbhResponseEntity());
//                }
//
//            }
//        }.execute();
//
//    }



}
