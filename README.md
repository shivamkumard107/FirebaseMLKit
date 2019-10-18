## Firebase ML Kit - Your starter to the world of open source :)
Firebase ML Kit comes with the following machine learning APIs which are implemented and are ready to use in the application.
1. Text Recognition
2. Face Detection
3. Object Detection and Tracking
4. Image Labeling
5. AutoML vision Edge
6. Barcode Scanning
7. Landmark Recognition
8. Language Identification
9. On-device Translation
10. Smart Reply

This is an open-source project where you can find the implemented source code from the link provided below or in application
https://github.com/shivamkumard107/FirebaseMLKit

You simply pass in data to the ML Kit library and it will give you the information you need. The on-device APIs process data quickly and will work even when there’s no network connection.

# How to run:

- Fork this repo, and clone it your system.
- Head over to https://firebase.google.com
- Click on "Go to Console" , found on the top right of the screen. This will redirect you to a login page. Sign-in with your Google account.
- Click "Create a Project". Follow the dialogs and create your project.
- Your project will show up on the home page of your Firebase account. Select your project, and this will lead you to a Firebase console.
- On the console page, you will find a "Get Started" display, under which you can click on the Android icon to link your Android project to your Firebase account.
- Follow these steps to link your project:
    * Under "Register App":
        - Enter your package name as com.developersk.firebasemlkitdemo 
        - Leave the optional fields blank. You will need a debug SHA-1 key if you intend to use any API which requires OAuth. To find your SHA-1 key, check out this [link]
        - Click 'Register'
    * Download the config file that shows up.
    * Move your google-services.json file to FirebaseMLKit/app .
    * Add the Firebase SDK dependencies that are listed under the "Add SDK" tab.
    * Run your app on your device, and you are done!

- Link for additional info: https://developer.android.com/studio/write/firebase

[link]: https://stackoverflow.com/questions/15727912/sha-1-fingerprint-of-keystore-certificate