# JackDialog-Android



Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}



Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.RazM10:JackDialog-Android:0.0.1'
	}


Initialization:

	JackDialog jackDialog = new JackDialog(context);

Set Dialog Title, Description, Buttons altogether:

	jackDialog
            .setTitle("Delete")
            .setDescription("Want to Delete?")
            .setPositiveButton("Delete", new PositiveButtonListener() {
                @Override
                public void onPositiveButtonClickListener(AlertDialog dialog) {
                    Toast.makeText(context, "Positive Button Clicked", Toast.LENGTH_SHORT).show();
                                
                    dialog.dismiss();
                }
            })
            .setNegativeButton("Cancel")
            .show();
