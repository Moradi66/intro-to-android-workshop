## Part two

Let’s Start Building the App Layout
------

#### 1. Open the layout file

   Navigate to `activity_main.xml` and double click to open it.

   ![alt text](screenshots/screenshot00001.png "Open the layout file")

   The file contains a `<ConstraintLayout>` and a `<TextView>`
      + Android Studio has automatically generated this. ConstraintLayout is a very powerful layout for complicated screens but we do not need something as complex as a ConstraintLayout yet so let’s change this to `<RelativeLayout>`

#### 2. Change the layout to a Relative layout

   Select the start of the `<ConstraintLayout>` and enter `RelativeLayout`. Android Studio should automatically change the closing tag for you.

   ![alt text](screenshots/screenshot00002.png "Change the layout to a Relative layout")
   
   Let's also remove all the `layout_constraintBottom_toBottomOf` etc fields.
   
   You should now have something that looks like this:
   
   ```xml
   <?xml version="1.0" encoding="utf-8"?>
   <RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context="com.android.thermostat.MainActivity"
        >
        
        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Hello World!"
            />
            
   </RelativeLayout>
   ```

#### 3. Amend the TextView

   Change the `android:text` value from `Hello World!` to `26`

   Let’s make this in the centre - with `android:layout_centerInParent = true`

   Let’s add a margin - with `android:layout_margin = 8dp`
   
   We want this to be the most prominent view on our screen, so let’s specify the text size with `android:textSize = 80sp`. We can also specify whether this is **bold** or _italics_ - let’s have this **bold** so set the `android:textStyle = bold`.

   *Note*: `dp` and `sp` are units of measurements. `dp` stands for _Density pixel_ while `sp` stands for _Scalable Pixel_. We often use `dp` for sizes of views and spaces in between, and `sp` for text only.

   For more information, feel free to read the explanation in the [material.io guidelines](https://material.io/guidelines/layout/units-measurements.html)

   Add an `android:id` to this TextView - doing so will allow us to locate and identify our TextView in code. Let’s call this `@+id/temperature_value`

   **Note**: You cannot have uppercase characters or spaces in the name. Therefore in order for the names to remain readable while making them more meaningful, we’ve used the underscore to separate the words.
   
   Our TextView should hopefully look something like this:
   
   ```xml
   <TextView
            android:id="@+id/temperature_value"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_margin="8dp"
            android:textSize="80sp"
            android:textStyle="bold"
            android:layout_centerInParent="true"
            android:text="26"
            />
   ```

#### 4. Add another TextView

   ![alt text](screenshots/screenshot00003.png "Add another TextView")

   Go to a new line and start typing `<TextView…` - Android Studio should auto-populate the details for you. Press enter to accept.

   `android:layout_height` and `android:layout_width` are required and must be defined. There are 2 commonly used values - `wrap_content` and `match_parent`.
      * `wrap_content`: the size of the view will match it’s contents
      * `match_parent `: the size of the view will match it’s parent

   `wrap_content` will suit our needs here.
   
   **Note**: There is also an `android:height` and `android:width` - Whereas `layout_height` and `layout_width` allows the view to scale dynamically, `height` and `width` refers to a set height and width of the view, so you would define this in `sp` or `dp`. `layout_height` and `layout_width` is still required and your app will crash without them. For more information, refer to [the documentation here](https://developer.android.com/reference/android/widget/TextView.html#attr_android%3aheight)

   Let’s enter something here - with `android:text = Temperature`
   
   And we can set the `textSize` to _16sp_

   Notice that the new view is right at the top of the screen left-hand corner of the screen? All new views added to the layout are aligned there. We now need to tell the layout to place our new TextView directly above the previous TextView.

   In order to do so, we need to enter `android:layout_above` and after `=` enter the ID of the TextView we want to align above. As we’ve named the first TextView which says “26” `@+id/temperature_value`, we can start typing `temperature_value` and Android Studio will automatically complete this for you.

   **Note**: It will now say this - `android:layout_above = @id/temperature_value`. Where has the `+` gone? Well, when we’re defining the name of the layout, we have to enter `@+id` at the start to specify _adding a new ID_. That’s why when we refer to this after creation we no longer need to tell Android Studio to add a new ID.
   
   We also want this to be in the centre, so set `android:layout_centerHorizontal = true`

   Now that this is done, we’ll need to give this view an ID too.
   
   So our second TextView should look something like this:
   
   ```xml
   <TextView
            android:id="@+id/temperature_label"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Temperature"
            android:textSize="16sp"
            android:layout_centerHorizontal="true"
            android:layout_above="@id/temperature_value"
            />
   ```
   
   Great! Things are starting to come together.

#### 5. Import the Image

   Download the following two images which we'll like to add to our project:
   
   ![alt text](../App/app/src/main/res/drawable/home.png "home icon")
   
   ![alt text](../App/app/src/main/res/drawable/dashboard.png "dashboard")
   
   Locate the `res/drawable` folder in the sidebar and right click. You’ll see this:

   ![alt text](screenshots/screenshot00005.png "Right click")

   Close to the bottom there is a _Reveal in Finder_ option. Select this.

   ![alt text](screenshots/screenshot00004.png "Menu options")

   This will open up a window showing where your drawable resources are saved in your computer. Move the image files you had saved at the start of this step in this folder. 

   ![alt text](screenshots/screenshot00006.png "Folder showing where resources are saved")

   We can now use these file in our project!

#### 6. Add the Image View

   ![alt text](screenshots/screenshot00007.png "the image file is now in our project")

   In order to display images in our app, we need to add an `ImageView`. Like `TextView`, `ImageView` is a _View_ and it allows us to specify how we want our image to be displayed.

   We specify which image file to use by entering the file name in `android:src` - so `android:src=“@drawable/home_image` will allow us to display our thermometer image.

   In order for the image view to appear above our `TextViews`, let’s add an ID, positioning and `centerInParent`. Try _home_image_, `android:layout_above="@id/temperature_label"` and _true_ respectively, like so: 
   
   ```xml
   <ImageView
            android:id="@+id/home_image"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:src="@drawable/home"
            android:layout_above="@id/temperature_label"
            android:layout_centerHorizontal="true"
            />
   ```
   **Note:** As an accessibility best practice, it is also advisable to add a `contentDescription`, e.g. `android:contentDescription="Home Icon"`. This allows for the `ImageView` to be _translated_ by accessibility software for visually impaired users.

   ![alt text](screenshots/screenshot00008.png "our image is now in the centre")
   
   If you like, repeat steps 5 & 6 for the other image called `dashboard.png`. The new image view properties should be something like this:
   
   ```xml
   <ImageView
            android:id="@+id/dashboard_image"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:src="@drawable/dashboard"
            android:contentDescription="Dashboard Image"
            android:layout_alignParentBottom="true"
            android:scaleType="centerCrop"
            />
   ```

#### 7. Add Buttons

   Let’s add buttons to allow users to interact with our app.

   Start typing `<Button…` and press enter to select the first option.

   ![alt text](screenshots/screenshot00010.png "select button")

   Then fill in the details like so:

   ![alt text](screenshots/screenshot00011.png "select button")
   
   ```xml
   <Button
                android:id="@+id/button_minus"
                android:layout_width="36dp"
                android:layout_height="36dp"
                android:layout_margin="8dp"
                android:text="-"
                />
   ```

   Add another button, this time labelling it as `button_add`
   
   ```xml
   <Button
                android:id="@+id/button_add"
                android:layout_width="36dp"
                android:layout_height="36dp"
                android:layout_margin="8dp"
                android:text="+"
                />
   ```
   
   After you’ve done this, add another button and name it `button_reset`
   
   ```xml
   <Button
                android:id="@+id/button_reset"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_margin="8dp"
                android:text="Reset"
                />
   ```

   We’ll like to have the buttons side-by-side so let’s put them in a nested layout. Remember when we started we created a layout called `RelativeLayout`? A nested layout refers to a layout within a layout.

   This time, let’s add a `LinearLayout` and place all our buttons within it.
   
   ```xml
       <LinearLayout
            android:id="@+id/button_holder"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            >

        <Button
                android:id="@+id/button_minus"
                android:layout_width="36dp"
                android:layout_height="36dp"
                android:layout_margin="8dp"
                android:text="-"
                />

        <Button
                android:id="@+id/button_reset"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_margin="8dp"
                android:text="Reset"
                />

        <Button
                android:id="@+id/button_add"
                android:layout_width="36dp"
                android:layout_height="36dp"
                android:layout_margin="8dp"
                android:text="+"
                />

    </LinearLayout>
   ```

   ![alt text](screenshots/screenshot00012.png "nested LinearLayout")

   `LinearLayout`s are useful when we want to display our views in a linear-fashion, be it horizontally or vertically. Unlike the `RelativeLayout` where you had to specify the relationships of the views, there is no need to do this in a `LinearLayout` as the following views are always placed below (in a vertical `LinearLayout`) or on the right of (in a horizontal `LinearLayout`) of the view before it.

   As we want our add button to be on the right of the minus button, a `android:orientation=“horizontal”` would work for us. You might notice that nothing changes. This is because _horizontal_ is the default orientation of the view, so even if this is not specified the view is already organised in this fashion. It is still good practice to define it to make it less ambiguous.

   Like any other view, we can then specify where we’re going to place this `LinearLayout`. The benefit of using a nested layout is also evident here - notice how both views moved simultaneously?

   
   Your file should now look something like this:
   
   ```xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context="com.android.thermostat.MainActivity"
        >

    <TextView
            android:id="@+id/temperature_value"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_margin="8dp"
            android:textSize="80sp"
            android:textStyle="bold"
            android:layout_centerInParent="true"
            android:text="26"
            />


    <TextView
            android:id="@+id/temperature_label"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Temperature"
            android:layout_marginTop="12dp"
            android:textSize="16sp"
            android:layout_centerHorizontal="true"
            android:layout_above="@id/temperature_value"
            />


    <ImageView
            android:id="@+id/home_image"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:src="@drawable/home"
            android:contentDescription="Home Icon"
            android:layout_above="@id/temperature_label"
            android:layout_centerHorizontal="true"
            />

    <ImageView
            android:id="@+id/dashboard_image"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:src="@drawable/dashboard"
            android:contentDescription="Dashboard Image"
            android:layout_alignParentBottom="true"
            android:scaleType="centerCrop"
            />


    <LinearLayout
            android:id="@+id/button_holder"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_centerHorizontal="true"
            android:layout_alignParentBottom="true"
            android:orientation="horizontal"
            >

        <Button
                android:id="@+id/button_minus"
                android:layout_width="36dp"
                android:layout_height="36dp"
                android:layout_margin="8dp"
                android:text="-"
                />

        <Button
                android:id="@+id/button_reset"
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:layout_margin="8dp"
                android:text="Reset"
                />

        <Button
                android:id="@+id/button_add"
                android:layout_width="36dp"
                android:layout_height="36dp"
                android:layout_margin="8dp"
                android:text="+"
                />

    </LinearLayout>


</RelativeLayout>

   ```
   
   ![alt text](screenshots/Screen%20Shot%202018-01-21%20at%2019.39.06.png "final view")
   
   If you run the app now, you’ll see all your changes on your emulator/phone.
   
   But nothing happens when you press the buttons!
   
   Let’s start to make things work - [Part three](../Part-3/instructions.md).
   

_Credits_
Images for project obtained from [Flat Icon](www.flaticon.com) - [Smashicons](https://www.flaticon.com/authors/smashicons)
