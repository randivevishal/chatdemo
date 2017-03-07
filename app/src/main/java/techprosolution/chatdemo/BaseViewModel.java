package techprosolution.chatdemo;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.ViewDataBinding;

import java.lang.ref.WeakReference;

/**
 * Created by vishalrandive on 07/03/17.
 */

public class BaseViewModel extends BaseObservable
{
    protected WeakReference<Context> mContext;
    protected int mCallerId;
    protected IOnEventCallbacks mIOnEventCallbacks;
    protected ViewDataBinding mBinding;

    public BaseViewModel(int callerId, Context context, IOnEventCallbacks callbacks) {
        mCallerId = callerId;
        mContext = new WeakReference<>(context);
        mIOnEventCallbacks = callbacks;
    }

    public ViewDataBinding getBinding() {
        return mBinding;
    }

    public interface IOnEventCallbacks {

        /***
         * Callback for specific event. Use id to identify the event.
         * @param callerId Request code sent to the viewModel to avoid conflicts in case of similar IDs between viewModels
         * @param id Any static final int defined in the ViewModel based on which the driver will switch actions
         * @param viewModelInstance Instance of the viewModel to access Model or other public variable
         */
        void onEvent(int callerId, int id, BaseViewModel viewModelInstance);
    }
}
