package com.investallign.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.investallign.R;
import com.investallign.activities.HomeActivity;
import com.investallign.entities.AccountBalanceEntity;
import com.investallign.fragments.InvestChartFragment;

import java.util.List;

/**
 * Created by root on 2/12/16.
 */
public class HomeFragmentAdapter extends RecyclerView.Adapter<HomeFragmentAdapter.MyViewHolder> {

    private List<AccountBalanceEntity> accountBalanceEntities;
    Context context;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView roundUpAmount, spentAmount, invest,tvInvestChart;
        public LinearLayout linearLayoutbackground;


        public MyViewHolder(View view) {
            super(view);
            roundUpAmount = (TextView) view.findViewById(R.id.recycle_row_home_fragment_tv_round_up);
            spentAmount = (TextView) view.findViewById(R.id.recycle_row_home_fragment_tv_spent);
            invest = (TextView) view.findViewById(R.id.recycle_row_home_fragment_tv_invest);
           tvInvestChart = (TextView)view.findViewById(R.id.recycle_row_home_fragment_tv_invest_chart);
            linearLayoutbackground = (LinearLayout) view.findViewById(R.id.recycle_row_home_fragment_background);
        }
    }


    public HomeFragmentAdapter(List<AccountBalanceEntity> accountBalanceEntities, Context context) {
        this.context = context;
        this.accountBalanceEntities = accountBalanceEntities;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycle_row_home_fragment, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        AccountBalanceEntity accountBalanceEntity = accountBalanceEntities.get(position);
        holder.roundUpAmount.setText(context.getResources().getString(R.string.Rs) + accountBalanceEntity.getRoundUpAmount());
        holder.spentAmount.setText(context.getResources().getString(R.string.Rs) + accountBalanceEntity.getSpendAmount());
        holder.invest.setText(context.getResources().getString(R.string.Rs) + accountBalanceEntity.getInvest());
        holder.tvInvestChart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Fragment newFragment = new InvestChartFragment();
                FragmentTransaction transaction = ((HomeActivity)context).getSupportFragmentManager().beginTransaction();
//                FragmentTransaction transaction = context.getFragmentManager().beginTransaction();

                transaction.replace(R.id.fragment_home, newFragment);
                transaction.addToBackStack(null);


                transaction.commit();

            }
        });
        if (accountBalanceEntity.getBgcolor().equalsIgnoreCase("orange")) {
            holder.linearLayoutbackground.setBackgroundColor(context.getResources().getColor(R.color.orange));
        } else {
            holder.linearLayoutbackground.setBackgroundColor(context.getResources().getColor(R.color.green));
        }


    }



    @Override
    public int getItemCount() {
        return accountBalanceEntities.size();
    }
}
