[![](https://jitpack.io/v/2coffees1team/GlideToVectorYou.svg)](https://jitpack.io/#2coffees1team/GlideToVectorYou)


# GlideToVectorYou
Load SVGs with Glide

## Introduction
GlideToVectorYou enables you to easily load your remote vector images (only .svg are supported for now) like other image formats.

The library is based on Glide and offers the same functionalities + svg support.

Changelog available [here](https://github.com/corouteam/GlideToVectorYou/releases).

## How to use

Add JitPack in your **root *build.gradle*** at the end of repositories:

```gradle
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
 ```
 
 Add the dependency in your **app *build.gradle***:
 
 ```gradle
 	dependencies {
	        implementation 'com.github.corouteam:GlideToVectorYou:v2.0.0'
	}
 ```

**There are 3 ways to use this library.**

## Lazy way
You just have to use a method:

```java
	GlideToVectorYou.justLoadImage(activity, IMAGE_URI, targetImageView)
```

The svg will be automatically downloaded and inserted in your target Image View.

*Easy eh?*

## Normal way

```java
        GlideToVectorYou
                .init()
                .with(this)
                .withListener(new GlideToVectorYouListener() {
                    @Override
                    public void onLoadFailed() {
                        Toast.makeText(context, "Load failed", Toast.LENGTH_SHORT).show()
                    }

                    @Override
                    public void onResourceReady() {
                        Toast.makeText(context, "Image ready", Toast.LENGTH_SHORT).show()
                    }
                })
                .setPlaceHolder(placeholderLoading, placeholderError)
                .load(IMAGE_URL, imageview); 
```

Here you have more methods to customize the behaviour of *GlideToVectorYou*. You can for example:

* set a custom listener to respond to events with ```withListener()```
* show place holders while the image is loading or the loading failed with ```setPlaceHolder()```.


## Advanced way
If you are a **Glide pro**, you can ask *GlideToVectorYou* to give you access to the original Glide's ```RequestBuilder```.

```java
        RequestBuilder<PictureDrawable> requestBuilder = GlideToVectorYou
                .init()
                .with(this)
                .getRequestBuilder();
```

Here you can use the variable requestBuilder like a normal Glide request. The only difference is that it will still continue to work with SVGs :)

Again, for example, you could apply a custom transition or crop the image:

```java
        requestBuilder
                .load(IMAGE_URI)
                .transition(DrawableTransitionOptions.withCrossFade())
                .apply(new RequestOptions()
                        .centerCrop())
                .into(imageView);
```

## Set SVG as background
If you need to load a .svg image as **backgroud** of a generic view, just call:

```java
	GlideToVectorYou.justLoadImageAsBackground(activity, IMAGE_URI, view)
```


## Licence
This library is shared under **Apache License 2.0**.

### Made with ♥ by Corouteam
We're Glid.. ehm... Glad to help you :D
