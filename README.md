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



## License:

MIT License

Copyright (c) 2020 Razaul Munir

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
© 2020 Git
