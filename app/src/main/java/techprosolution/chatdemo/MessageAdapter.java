package techprosolution.chatdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vishalrandive on 07/03/17.
 */

public class MessageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
    private Context mContext;
    private List<MessageModel> messageList = new ArrayList<>();
    private int mCallerId;
    private BaseViewModel.IOnEventCallbacks mCallback;

    public MessageAdapter(Context context, int callerId, BaseViewModel.IOnEventCallbacks callback)
    {
        mContext = context;
        mCallerId = callerId;
        mCallback = callback;
    }

    public void setMessageList(List<MessageModel> MessageList)
    {
        messageList = MessageList;
    }

    public void addMessage(MessageModel messageModel){
        messageList.add(messageModel);
    }

    public List<MessageModel> getMessageList(){
        return messageList;
    }

    @Override
    public int getItemViewType(int position)
    {
        return super.getItemViewType(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        return new MessageItemViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_message_item, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position)
    {
        MessageItemViewHolder messageItemViewHolder = (MessageItemViewHolder) viewHolder;
        messageItemViewHolder.setViewModel(mCallerId, mCallback, messageList.get(position));
    }

    @Override
    public int getItemCount()
    {
        return messageList.size();
    }
}