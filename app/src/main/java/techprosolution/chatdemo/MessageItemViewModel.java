package techprosolution.chatdemo;

import android.content.Context;
import android.databinding.Bindable;
import android.view.View;

import techprosolution.chatdemo.databinding.LayoutMessageItemBinding;

/**
 * Created by vishalrandive on 07/03/17.
 */

public class MessageItemViewModel extends BaseViewModel
{
    private LayoutMessageItemBinding mBinding;

    public MessageItemViewModel(int callerId, Context context, IOnEventCallbacks callbacks, LayoutMessageItemBinding binding)
    {
        super(callerId, context, callbacks);
        mBinding = binding;
    }

    @Bindable
    public int getUserVisibility()
    {
        return (mBinding.getDataModel() != null && mBinding.getDataModel().senderId == ChatActivity.OWN_ID) ? View.GONE : View.VISIBLE;
    }

    @Bindable
    public int getOwnVisibility()
    {
        return mBinding.getDataModel() != null && mBinding.getDataModel().senderId == ChatActivity.OWN_ID ? View.VISIBLE : View.GONE;
    }
}
