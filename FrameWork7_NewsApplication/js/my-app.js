// Initialize your app
var myApp = new Framework7();

// Export selectors engine
var $$ = Dom7;
// Add views
var view1 = myApp.addView('#view-1');
var view2 = myApp.addView('#view-2', {
    // Because we use fixed-through navbar we can enable dynamic navbar
    dynamicNavbar: true
});
var view3 = myApp.addView('#view-3');
var view4 = myApp.addView('#view-4');
var view5 = myApp.addView('#view-5');
var view6 = myApp.addView('#view-6');
var view7 = myApp.addView('#view-7');
var view8 = myApp.addView('#view-8');