package techprosolution.chatdemo;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import techprosolution.chatdemo.databinding.LayoutMessageItemBinding;

/**
 * Created by vishalrandive on 07/03/17.
 */

public class MessageItemViewHolder extends RecyclerView.ViewHolder
{
    private LayoutMessageItemBinding mBinding;

    public MessageItemViewHolder(View itemView)
    {
        super(itemView);
        mBinding = DataBindingUtil.bind(itemView);
    }

    public void setViewModel(int callerId, BaseViewModel.IOnEventCallbacks mViewModelCallbacks, MessageModel messageModel) {
        mBinding.setDataModel(messageModel);
        mBinding.setViewModel(new MessageItemViewModel(callerId, mBinding.getRoot().getContext(), mViewModelCallbacks, mBinding));
        mBinding.executePendingBindings();
    }

}
