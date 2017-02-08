package com.investallign.fragments;


import android.app.ProgressDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.investallign.R;
import com.investallign.activities.HomeActivity;
import com.investallign.adapters.RevenueFragmentAdapter;
import com.investallign.entities.RevenueFragmentEntity;
import com.investallign.interfaces.OnPageChangeListener;

import java.util.ArrayList;
import java.util.List;


public class RevenueRouteFragment extends Fragment implements OnPageChangeListener {
     private static final String TAG = RevenueRouteFragment.class.getSimpleName();

    // Movies json url
    private static final String url = "http://api.androidhive.info/json/movies.json";
    private ProgressDialog pDialog;
    private List<RevenueFragmentEntity> movieList = new ArrayList<RevenueFragmentEntity>();
    private ListView listView;
    private RevenueFragmentAdapter adapter;
    private View v;
    private RevenueFragmentEntity revenueFragmentEntity;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_revenue_route, container, false);

        listView = (ListView) v.findViewById(R.id.fragment_revenue_route_listview);


        pDialog = new ProgressDialog(getContext());
        // Showing progress dialog before making http request
        pDialog.setMessage("Loading...");
        pDialog.show();

        // changing action bar color

        for (int i = 1; i <= 10; i++) {
            revenueFragmentEntity = new RevenueFragmentEntity();

            revenueFragmentEntity.setLeftSideImage(String.valueOf(R.drawable.ic_profil_pic));

            if (i % 2 == 0) {
                revenueFragmentEntity.setRightSideImage(String.valueOf(R.drawable.ic_plus_round));
                revenueFragmentEntity.setTitle("Taylor Swift");
            } else{
                revenueFragmentEntity.setRightSideImage(String.valueOf(R.drawable.ic_plus_true));
                revenueFragmentEntity.setTitle("Jenifer Lawrance");
            }
            revenueFragmentEntity.setSubTitle("Succes 100%");
            movieList.add(revenueFragmentEntity);
        }

        adapter = new RevenueFragmentAdapter(getContext(), movieList);
        listView.setAdapter(adapter);
        hidePDialog();
        return v;
    }

    private void hidePDialog() {
        if (pDialog != null) {
            pDialog.dismiss();
            pDialog = null;
        }
    }

    @Override
    public void onPage() {
        HomeActivity.btnSetting.setVisibility(View.GONE);
//        if (!flag) {
//            if (UtilityManager.isConnected(getContext())) {
//                isShowProgressBar(View.VISIBLE);
//                getFAQDetails();
//            } else {
//                flag = true;
//                showHideComponents(View.VISIBLE, getString(R.string.no_internet_connection));
//                isShowProgressBar(View.GONE);
//            }
//        }
    }
//
//    public RelativeLayout getFaqLayout() {
//        return faqLayout;
//    }
//
//    public void setFaqLayout(RelativeLayout faqLayout) {
//        this.faqLayout = faqLayout;
//    }
//
//    private void prepareListData() {
//        faqGroupCategoriesEntities = new ArrayList<FAQGroupCategoriesEntity>();
//        faqChildCategoriesEntities = new HashMap<FAQGroupCategoriesEntity, List<FAQChildCategoriesEntity>>();
//
//        for (int i = 0; i < questions.length; i++) {
//            faqGroupCategoriesEntities.add(new FAQGroupCategoriesEntity(questions[i]));
//            List<FAQChildCategoriesEntity> list1 = new ArrayList<FAQChildCategoriesEntity>();
//            list1.add(new FAQChildCategoriesEntity(answers[i]));
//            faqChildCategoriesEntities.put(faqGroupCategoriesEntities.get(i), list1);
//        }
//        faqlistAdapter = new FAQSsCategoriesListAdapter(this, faqGroupCategoriesEntities, faqChildCategoriesEntities);
//
//        faqCatagoriesList.setAdapter(faqlistAdapter);
//
//
//    }
//
//
//    public synchronized void getFAQDetails() {
//        try {
//            responseListenerForfaqDetails = new ResponseListener() {
//
//                @Override
//                public void onResponse(Object object) {
//                    if (getActivity() != null) {
//                    isShowProgressBar(View.GONE);
//                    flag = true;
//                    progressBarCircularIndeterminate.clearAnimation();
//                        onAboutusResponse(object);
//                    }
//                }
//
//            };
//
//            KhelMahaKumbhManager.getInstance().getFAQDetails(getContext(), AppConstants.URL + RequestType.GET_FAQ.getMethodName(),
//                    responseListenerForfaqDetails, generateJSON("e8bcf071dbbef84"));
//        } catch (Exception e) {
//            showHideComponents(View.VISIBLE, getString(R.string.msg_server_error));
//            isShowProgressBar(View.GONE);
//            flag = true;
//            faqCatagoriesList.setVisibility(View.GONE);
//            Log.e(TAG, e.toString(), e);
//        }
//
//    }
//
//    public void onAboutusResponse(Object object) {
//        FAQFragmentKhelmahakumbhResponseEntity faqKhelmahakumbhResponseEntity = (FAQFragmentKhelmahakumbhResponseEntity) object;
//        if ("".equals(faqKhelmahakumbhResponseEntity.getResponseCode())) {
//
//            faqCatagoriesList.setVisibility(View.GONE);
//            showHideComponents(View.VISIBLE, getString(R.string.msg_server_error));
//            isShowProgressBar(View.GONE);
//        } else if (faqKhelmahakumbhResponseEntity.getResponseCode().equals(JSONConstants.HTTP_200)) {
//            questions = new String[faqKhelmahakumbhResponseEntity.getFaqFragmentKhelmahakumbhEntities().size()];
//            answers = new String[faqKhelmahakumbhResponseEntity.getFaqFragmentKhelmahakumbhEntities().size()];
//            for (int i = 0; i < faqKhelmahakumbhResponseEntity.getFaqFragmentKhelmahakumbhEntities().size(); i++) {
//                String str = faqKhelmahakumbhResponseEntity.getFaqFragmentKhelmahakumbhEntities().get(i).getFaqQuestion() + "\n";
//                questions[i] = str;
//                String strans = faqKhelmahakumbhResponseEntity.getFaqFragmentKhelmahakumbhEntities().get(i).getFaqAnswer() + "\n";
//                answers[i] = strans;
//                showHideComponents(View.GONE, null);
//                isShowProgressBar(View.GONE);
//                faqCatagoriesList.setVisibility(View.VISIBLE);
//            }
//            prepareListData();
//        } else {
//            isShowProgressBar(View.GONE);
//            showHideComponents(View.VISIBLE, getString(R.string.msg_server_error));
//        }
//    }
//
//    public RequestBody generateJSON(final String key) {
//        final FormEncodingBuilder builder = new FormEncodingBuilder();
//        builder.addEncoded(JSONConstants.KEY, key);
//        return builder.build();
//    }
//
//    @Override
//    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
//
//        return false;
//    }
//
//    @Override
//    public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
//        if (faqCatagoriesList.isGroupExpanded(groupPosition)) {
//            faqCatagoriesList.collapseGroupWithAnimation(groupPosition);
//
//        } else {
//            faqCatagoriesList.expandGroupWithAnimation(groupPosition);
//        }
//        return true;
//    }
//
//    @Override
//    public void onGroupExpand(int groupPosition) {
//
//        if (lastExpandedPosition != -1
//                && groupPosition != lastExpandedPosition) {
//
//            faqCatagoriesList.collapseGroup(lastExpandedPosition);
//        }
//
//        lastExpandedPosition = groupPosition;
//    }
//
//
//    @Override
//    public void onRefresh() {
//        getFAQDetails();
//
//    }
//
//    private void showHideComponents(int viewVisibility, String msg) {
//        if (msg != null) {
//            faqFragmentNoConText.setText(msg);
//            UtilityManager.setErrorImage(getActivity(), faqFragmentNoConImage, msg);
//        }
//        faqFragmentNoConImage.setVisibility(viewVisibility);
//        faqFragmentNoConText.setVisibility(viewVisibility);
//    }
//
//    private void isShowProgressBar(int visible) {
//        progressBarCircularIndeterminate.setVisibility(visible);
//    }
}