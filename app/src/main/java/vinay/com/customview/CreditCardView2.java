package vinay.com.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by vgaba on 4/28/2015.
 */
public class CreditCardView2 extends RelativeLayout{

    private String mCardNumber = "0000 0000 0000 0000";
    private String mExpiryDate = "01/11";
    private int mCardNumberTextColor = Color.WHITE;
    private int mExpiryDateTextColor = Color.WHITE;
    private int mType = 0;



    public CreditCardView2(Context context) {
        super(context);

    }

    public CreditCardView2(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.CreditCardView2,
                0, 0);

        try {
            mCardNumber = a.getString(R.styleable.CreditCardView2_cardNumber);
            mExpiryDate = a.getString(R.styleable.CreditCardView2_expiryDate);
            mCardNumberTextColor = a.getColor(R.styleable.CreditCardView2_cardNumberTextColor, Color.WHITE);
            mExpiryDateTextColor = a.getColor(R.styleable.CreditCardView2_expiryDateTextColor, Color.WHITE);
            mType = a.getInt(R.styleable.CreditCardView2_type,0);
        } finally {
            a.recycle();
        }

        /*PaintDrawable pd = new PaintDrawable();
        pd.setCornerRadius(20);
        setBackgroundDrawable(pd);*/


        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.creditcardview, this, true);

        TextView cardNumber = (TextView)getChildAt(0);
        cardNumber.setText(mCardNumber);
        cardNumber.setTextColor(mCardNumberTextColor);

       /* TextView expiryDate = (TextView)getChildAt(1);
        cardNumber.setText(mExpiryDate);
        cardNumber.setTextColor(mExpiryDateTextColor);*/

        ImageView type = (ImageView)getChildAt(1);
        type.setBackgroundResource(getLogo(mType));


    }





    public String getCardNumber(){

        return mCardNumber;
    }

    public void setCardNumber(String cardNumber){
        mCardNumber = cardNumber;
        invalidate();
        requestLayout();
    }

    public int getCardNumberTextColor(){

        return mCardNumberTextColor;
    }

    public void setCardNumberTextColor(int cardNumberTextColor){
        mCardNumberTextColor = cardNumberTextColor;
        invalidate();
        requestLayout();
    }

    public String getExpiryDate(){

        return mExpiryDate;
    }

    public int getExpiryDateTextColor(){

        return mExpiryDateTextColor;
    }

    public void setExpiryDateTextColor(int expiryDateTextColor){
        mExpiryDateTextColor = expiryDateTextColor;
        invalidate();
        requestLayout();
    }

    public void setExpiryDate(String expiryDate) {
        mExpiryDate = expiryDate;
        invalidate();
        requestLayout();
    }

    public int getType(){

        return mType;
    }

    public void setType(int type){

         mType = type;
        invalidate();
        requestLayout();
    }

    public int getLogo(int type){

        switch(type){
            case 0: return R.drawable.visa;


            case 1: return R.drawable.mastercard;


            case 2:

        }

       return 0;
    }
}