package dev.app.koutsodimakisgeo.zulutradeassignment.Adapter;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import dev.app.koutsodimakisgeo.zulutradeassignment.Model.ProductModel;
import dev.app.koutsodimakisgeo.zulutradeassignment.R;


/**
 * Created by koutsodimakisgeo on 28-Sep-17.
 */


    public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyHolder>{

        int pipMultiplier;
        float spreadValue;

        List<ProductModel> list;
        public RecyclerAdapter(List<ProductModel> list) {
            this.list = list;
        }

        @Override
        public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list,parent,false);
            MyHolder myHolder = new MyHolder(view);
            return myHolder;
        }


    @Override
        public void onBindViewHolder(MyHolder holder, int position) {
            ProductModel product = list.get(position);
            holder.currencyComb.setText(product.getName());

            pipMultiplier=10000;
            //Set Sell values
            String sellString = Float.toString(product.getSell());
            String buyString = Float.toString(product.getBuy());


            if ((sellString.length() >=5) &&(buyString.length() >=6)){
                //Set sell values
                String setSellString = String.format("%.2f",product.getSell());
                holder.sell.setText(setSellString);
                String sellHighlight =  sellString.substring((sellString.length()-3),sellString.length()-1);
                holder.sellPip.setText(sellHighlight);
                String sellFractionalString = (sellString.substring(sellString.length()-1));
                holder.sellFractional.setText(sellFractionalString);

                //Set nuy values
                String setBuyString = String.format("%.2f",product.getBuy());
                holder.buy.setText(setBuyString);
                String buyHighlight =  buyString.substring((buyString.length()-3),buyString.length()-1);
                holder.buyPip.setText(buyHighlight);
                String buyFractionalString = (buyString.substring(buyString.length()-1));
                holder.buyFractional.setText(buyFractionalString);
            }else if ((sellString.length() <=4)  &&(buyString.length() >=4)){
                //Set sell values
                String setSellString = String.format("%.1f",product.getSell());
                holder.sell.setText(setSellString);
                String sellHighlight =  sellString.substring((sellString.length()-3),sellString.length()-1);
                holder.sellPip.setText(sellHighlight);
                String sellFractionalString = (sellString.substring(sellString.length()-1));
                holder.sellFractional.setText(sellFractionalString);
                //Set nuy values
                String setBuyString = String.format("%.1f",product.getBuy());
                holder.buy.setText(setBuyString);
                String buyHighlight =  buyString.substring((buyString.length()-3),buyString.length()-1);
                holder.buyPip.setText(buyHighlight);
                String buyFractionalString = (buyString.substring(buyString.length()-1));
                holder.buyFractional.setText(buyFractionalString);
            }/*else{
                //Set sell values
                String setSellString = String.format("%.f",product.getSell());
                holder.sell.setText(setSellString);
                String sellHighlight =  sellString.substring((sellString.length()-3),sellString.length()-1);
                holder.sellPip.setText(sellHighlight);
                String sellFractionalString = (sellString.substring(sellString.length()-1));
                holder.sellFractional.setText(sellFractionalString);
                //Set nuy values
                String setBuyString = String.format("%.f",product.getBuy());
                holder.buy.setText(setBuyString);
                String buyHighlight =  buyString.substring((buyString.length()-3),buyString.length()-1);
                holder.buyPip.setText(buyHighlight);
                String buyFractionalString = (buyString.substring(buyString.length()-1));
                holder.buyFractional.setText(buyFractionalString);
            }*/



            //Spread
            spreadValue=(product.getBuy()-product.getSell())*pipMultiplier;
            String spreadString = String.format ("%,.1f", spreadValue);
            holder.spread.setText(spreadString);






    }




    @Override
        public int getItemCount() {
            return list.size();
        }

        class MyHolder extends RecyclerView.ViewHolder{
            TextView currencyComb;
            TextView sell;
            TextView buy;
            TextView spread;
            TextView buyPip;
            TextView sellPip;
            TextView buyFractional;
            TextView sellFractional;
            RelativeLayout llSell;

            public MyHolder(View itemView) {
                super(itemView);
                currencyComb = (TextView) itemView.findViewById(R.id.currencyComb);
                sell = (TextView)itemView.findViewById(R.id.sell);
                buy = (TextView)itemView.findViewById(R.id.buy);
                spread = (TextView)itemView.findViewById(R.id.spread);
                buyPip = (TextView)itemView.findViewById(R.id.buyPip);
                sellPip = (TextView)itemView.findViewById(R.id.sellPip);
                buyFractional = (TextView)itemView.findViewById(R.id.buyFractional);
                sellFractional = (TextView)itemView.findViewById(R.id.sellFractional);
                llSell = (RelativeLayout)itemView.findViewById(R.id.llSell);



            }



        }

    }

