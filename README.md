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
The main idea is to create interfaces for each layer, then create classes that implements these interfaces.</br>
This way if you remove any implementation you still got your functionality preserved.

### Model layer:
(In antoniolg's example it's named interactor.)
</br>
1. Create an interface for the model (OpenWeatherModel.java)
</br>
it contains main functionalities like getweather, stop getting weather and so.
2. Create a class that implements that model (OpenWeatherModelImpl.java) it contains the implementations for the methods.
### Presenter layer:
1. Create an interface for the presenter (OpenWeatherPresenter.java)</br>
You should add methods to get data from the model layer and also methods that will deal with the view layer like update data, show and hide progress etc..
2. Create a class that implements the presenter (OpenWeatherPresenterImpl)
</br>
This class holds references to both the view object and the interactor object, to be able to communicate and transfer data between both layers.
### View Layer:
1. Create an interface for the view (OpenWeatherView.java)</br>
This interface has the UI methods you will need in your app that would be used also by the presenter, like update data, show and hide progress, show error etc..
2. Create Activity/Fragment that implements this interface and override the methods.</br>
In that Activity/Fragment you make  a new instance of the presenter (Here [Dagger2] (https://google.github.io/dagger/) is used) and then call the presenter.getData to start the logic of the app.
3. Sometimes if a fragment is used it's prefered that the creation of the presenter is done in the holding Activity not the fragment itself.
