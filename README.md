# cordova-plugin-receive-text
This is a cordova Plugin using which one can receive ( using Intent ) text from other apps in Cordova app.

# Installation

## Install Cordova If You Do Not Have
```
npm i -g cordova
```

## Add the Plugin In The Project
```
 cordova plugin add https://github.com/preetsc27/cordova-plugin-receive-text.git
```

## index.html
```
 <script>
      document.addEventListener("deviceready", receiveTextFromIntent, false);

      function receiveTextFromIntent() {
        window.plugins.listenForTextIntents(
          "",
          success => {
            console.log(success);
            alert(success.toString());
          },
          error => {
            alert(error);
          }
        );
      }
    </script>
```

## If you are using React.js then add it in App.jsx
```
componentDidMount(){
  window.plugins.listenForTextIntents(
      "",
      success => {
        console.log(success);
        alert(success.toString());
      },
      error => {
        alert(error);
      }
    );
  }
}
```
