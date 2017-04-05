package com.rawalinfocom.rcontact.adapters;

import android.content.Context;
import android.graphics.drawable.LayerDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.rawalinfocom.rcontact.R;
import com.rawalinfocom.rcontact.RatingHistoryPopupDialog;
import com.rawalinfocom.rcontact.helper.Utils;
import com.rawalinfocom.rcontact.model.NotiRatingItem;
import com.rawalinfocom.rcontact.notifications.NotificationPopupDialog;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by maulik on 15/03/17.
 */

public class NotiRatingHistoryAdapter extends RecyclerView.Adapter<NotiRatingHistoryAdapter.MyViewHolder> {


    private Context context;
    private List<NotiRatingItem> list;
    private int recyclerPosition;
    RatingHistoryPopupDialog notificationPopupDialog;

    public NotiRatingHistoryAdapter(Context context, List<NotiRatingItem> list, int recyclerPosition) {
        this.context = context;
        this.list = list;
    }

    public void updateList(List<NotiRatingItem> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.image_rater)
        ImageView imageRater;
        @BindView(R.id.text_rater_name)
        TextView textRaterName;
        @BindView(R.id.text_rating_given)
        TextView textRatingGiven;
        @BindView(R.id.given_rating_bar)
        RatingBar givenRatingBar;
        @BindView(R.id.text_rating_noti_time)
        TextView textRatingNotiTime;

        @BindView(R.id.text_rating_detail_info)
        TextView textRatingDetailInfo;

        @BindView(R.id.button_rating_view_reply)
        AppCompatButton buttonRatingViewReply;
        @BindView(R.id.relative_row_layout)
        RelativeLayout relativeRowMain;
        @BindView(R.id.history_place_holder)
        TextView historyPlaceHolder;

        public MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_noti_rating_history, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        final NotiRatingItem item = list.get(position);
        holder.textRaterName.setText(item.getRaterName());
        Float rating = Float.parseFloat(item.getRating());
        holder.textRatingGiven.setText(rating + "");
        holder.givenRatingBar.setRating(rating);

        LayerDrawable stars = (LayerDrawable) holder.givenRatingBar.getProgressDrawable();
        Utils.setRatingStarColor(stars.getDrawable(2), ContextCompat.getColor(context, R.color
                .vivid_yellow));
        Utils.setRatingStarColor(stars.getDrawable(1), ContextCompat.getColor(context, android.R
                .color.darker_gray));
        Utils.setRatingStarColor(stars.getDrawable(0), ContextCompat.getColor(context, android.R
                .color.darker_gray));

        if (recyclerPosition == 2) {
            holder.textRatingNotiTime.setText(Utils.formatDateTime(item.getNotiTime(), "dd MMM, hh:mm a"));
        } else {
            holder.textRatingNotiTime.setText(Utils.formatDateTime(item.getNotiTime(), "hh:mm a"));
        }
        if (item.getHistoryType() == 0) {
            holder.historyPlaceHolder.setText(context.getResources().getString(R.string.text_you_rated));
            holder.textRatingDetailInfo.setText("You wrote comment and give rating to " + item.getRaterName());
        } else {
            holder.historyPlaceHolder.setText(context.getResources().getString(R.string.text_rated_you));
            holder.textRatingDetailInfo.setText("You receive comment rating from" + item.getRaterName());
        }
        //holder.buttonRatingViewReply.setText("VIEW REPLY");
        holder.relativeRowMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> arrayListComments = new ArrayList<>();
                arrayListComments.add(item.getRaterName());
                arrayListComments.add("Rating");
                arrayListComments.add(item.getComment());
                arrayListComments.add(Utils.formatDateTime(item.getCommentTime(), "dd MMM, hh:mm a"));
                arrayListComments.add(item.getReply());
                arrayListComments.add(Utils.formatDateTime(item.getReplyTime(), "dd MMM, hh:mm a"));
                notificationPopupDialog = new RatingHistoryPopupDialog(context, arrayListComments, true);
                if (item.getHistoryType() == 0) {
                    notificationPopupDialog.setDialogTitle(context.getResources().getString(R.string.text_you_rated) + " " + item.getRaterName());
                } else {
                    notificationPopupDialog.setDialogTitle(item.getRaterName() + " " + context.getResources().getString(R.string.text_rated_you));
                }
                notificationPopupDialog.setRatingInfo(item.getRating());
                notificationPopupDialog.showDialog();
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
