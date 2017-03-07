package techprosolution.chatdemo;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import techprosolution.chatdemo.databinding.ActivityChatBinding;

public class ChatActivity extends AppCompatActivity implements View.OnClickListener
{
    public final static int OWN_ID = 100;
    public final static int USER_ID = 101;
    private ActivityChatBinding mBinding;
    public static int DEFAULT_CALLER_ID = 111;
    public HashMap<String, UserModel> userHashMap = new HashMap<>();
    private MessageAdapter mAdapter;
    private UserHelper mUserHelper;
    private MessageHelper mMessageHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(ChatActivity.this, R.layout.activity_chat);

        mUserHelper = new UserHelper();
        userHashMap = mUserHelper.getUsers();

        mMessageHelper = new MessageHelper();
        List<MessageModel> mMessageList = mMessageHelper.getMessages();

        if(mMessageList == null)
        {
            mMessageList = new ArrayList<>();
        }

        mBinding.progressbar.setVisibility(View.GONE);
        mBinding.rvMessages.setLayoutManager(new LinearLayoutManager(this));
        mBinding.rvMessages.setHasFixedSize(true);
        mAdapter = new MessageAdapter(this, DEFAULT_CALLER_ID, iOnEventCallbacks);
        mAdapter.setMessageList(mMessageList);
        mBinding.rvMessages.setAdapter(mAdapter);
        mBinding.btnSend.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        switch(view.getId())
        {
            case R.id.btn_send:
                sendMessage();
                break;
        }
    }

    private void sendMessage()
    {
        String messageText = mBinding.etMessage.getText().toString();

        if(TextUtils.isEmpty(messageText))
        {
            Toast.makeText(this, "Please enter message", Toast.LENGTH_SHORT).show();
            return;
        }

        MessageModel messageModel = new MessageModel();
        messageModel.messageText = messageText;
        messageModel.id = 0;
        messageModel.messageTime = Utility.getTime();
        messageModel.senderId = OWN_ID;
        mAdapter.addMessage(messageModel);

        MessageModel userMessageModel = new MessageModel();
        userMessageModel.messageText = "Auto Answer";
        userMessageModel.id = 0;
        userMessageModel.messageTime = Utility.getTime();
        userMessageModel.senderId = USER_ID;
        mAdapter.addMessage(userMessageModel);

        mMessageHelper.addMessages(mAdapter.getMessageList());
        mBinding.etMessage.setText("");
        mAdapter.notifyDataSetChanged();
        mBinding.rvMessages.smoothScrollToPosition(mAdapter.getItemCount() - 1);
    }

    BaseViewModel.IOnEventCallbacks iOnEventCallbacks = new BaseViewModel.IOnEventCallbacks()
    {
        @Override
        public void onEvent(int callerId, int id, BaseViewModel viewModelInstance)
        {
            switch(callerId)
            {

            }
        }
    };

}
