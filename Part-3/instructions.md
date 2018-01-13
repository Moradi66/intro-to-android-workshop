# intro-to-android-workshop
## Part three

Adding Logic to the App
------

Now let’s start writing the Java code!

1. Locate the views without our layout and create fields

   When we created our project, Android Studio had generated the `MainActivity.java` file for us. 

   ![alt text](../Part-1/screenshots/screenshot00007.png “Original file”)

   In it, our `activity_main.xml` is linked to it and set as the view.

   In order for us to create interactions with what’s in our view, we need to locate them with the IDs we’ve given them earlier and add them as fields to our file. The method we need to use is called `findViewById`

   Outside of the `onCreate` method, we declare the fields as such:

   ```  private TextView temperatureDisplay;
  private Button plusButton;
  private Button minusButton;
  private Button resetButton;```

   And in the onCreate, we assign the fields with the following references:

   ```    temperatureDisplay = findViewById(R.id.temperature_value);
    plusButton = findViewById(R.id.button_add);
    minusButton = findViewById(R.id.button_minus);
    resetButton = findViewById(R.id.button_reset);```

   Our app should look like this so far:

   ![alt text](screenshots/screenshot00001.png “findViewById”)

2. Set an `onClickListener` to the plus button

   An `onClickListener` allows us to specify what should happen when the user clicks on our views. Here, we’ll assign it to our add button; you can also add `onClickListener` to any other view.

   Start by typing `plusButton.setOnClickListener(new OnClickListener` - when you press enter, Android Studio should populate the remaining lines for you. If not, copy and paste the below:

   ```    plusButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
         // your method here
      }
    });```

   Now whenever the button is pressed, the `onClick` method is triggered. We can put our desired action within this.

   For now, let’s add a `Toast`. A `Toast` is a little message at the bottom of the screen.

   Inside the `onClick` method, add the following: 

   ```    Toast.makeText(getApplicationContext(), “+1”, Toast.LENGTH_SHORT).show();```

   Our file should look like this now

   ![alt text](screenshots/screenshot00002.png “Toast”)

   Now run the app and click the add button. You should see a message saying “+1” every time you click on the button.

3. Add onClickListeners to the minus and reset button

   Repeat Step 2 for the other buttons. For the minus button, set the message to “-1” and the reset button “reset” so as to differentiate the different method calls.

   Our file should now look like this:

   ![alt text](screenshots/screenshot00003.png “Toast for all buttons”)


Now we’re ready to move on to coding more logic for our app! [Part four](../Part-4/instructions.md).