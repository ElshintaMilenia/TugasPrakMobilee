package com.example.myflexiblefragment;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class OptionDialogFragment extends DialogFragment implements View.OnClickListener{
    private RadioGroup rgOptions;
 private RadioButton rbSaf, rbMou, rbLvg, rbMoyes;
 private OnOptionDialogListener onOptionDialogListener;
 public OptionDialogFragment() {
         // Required empty public constructor
        }
 public OnOptionDialogListener getOnOptionDialogListener() {
         return onOptionDialogListener;
         }
 public void setOnOptionDialogListener(OnOptionDialogListener onOptionDialogListener) {
         this.onOptionDialogListener = onOptionDialogListener;
         }
 @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         View view = inflater.inflate(R.layout.fragment_option_dialog, container, false);
     Button btnChoose = (Button) view.findViewById(R.id.btn_choose);
         btnChoose.setOnClickListener(this);
     Button btnClose = (Button) view.findViewById(R.id.btn_close);
         btnClose.setOnClickListener(this);
         rgOptions = (RadioGroup)view.findViewById(R.id.rg_options);
         rbSaf = (RadioButton)view.findViewById(R.id.rb_saf);
         rbLvg = (RadioButton)view.findViewById(R.id.rb_lvg);
         rbMou = (RadioButton)view.findViewById(R.id.rb_mou);
         rbMoyes = (RadioButton)view.findViewById(R.id.rb_moyes);
         return view;
         }
 @Override
 public void onClick(View v) {
         switch (v.getId()){
             case R.id.btn_close:
                 getDialog().cancel();
                 break;
             case R.id.btn_choose:
                 int checkedRadioButtonId = rgOptions.getCheckedRadioButtonId();
                 if (checkedRadioButtonId != -1){
                     String coach = null;
                     switch (checkedRadioButtonId){
                         case R.id.rb_saf:
                             coach = rbSaf.getText().toString().trim();
                             break;
                         case R.id.rb_mou:
                             coach = rbMou.getText().toString().trim();
                             break;
                         case R.id.rb_lvg:
                             coach = rbLvg.getText().toString().trim();
                             break;
                         case R.id.rb_moyes:
                             coach = rbMoyes.getText().toString().trim();
                             break;
                         }
                     getOnOptionDialogListener().onOptionChoosen(coach);
                     getDialog().cancel();
                     }
                 break;
             }
         }
 public interface OnOptionDialogListener{
 void onOptionChoosen(String text);
 }
}
