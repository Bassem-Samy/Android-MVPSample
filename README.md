# Android-MVPSample
This is a simple android app, that explains MVP implementation in android.
</br>
The MVP implementation is based on [antoniolg's](https://github.com/antoniolg/androidmvp) androidmvp project.
</br>
It's avery neat and clean explanation of mvp but thought to make a simpler project to explain it.
## MVP Structure:
The main idea of MVP, is to have a model layer, a view layer and a presentation layer.
### The model layer:
This layer is what holds the business logic of the module you are working on, for example getting data, filtering data, saving data in db, add data to favorites etc.. it's the logic mainly
### The view layer:
This layer is responsible for the UI part, like displaying data, show filtered data, update data status in the UI, ask user to enter certain input etc...
### The presenter layer:
This layer is responsible for communication between the view and the model layer, for example, the presenter would ask the model layer to get data, then after having the data it tells the ui to display this loaded data or it can be the other way around, the user enters a search critira and some search results should be displayed what happens is, the UI tells the presenter to search for the criteria, the presenter then asks the model to get data according to that filter, after the model gets the data it replys back to the presetner, so the presenter tells the ui to display this filtered data.

## How to implement MVP in Android:
