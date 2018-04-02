# GlideToVectorYou
Load SVG in Android with Glide

## Introduction
GlideToVectorYou enables you to easily load your remote vector images (only .svg are supported for now) like other image formats.
The library is based on Glide and offers the same functionalities + svg support.

**There are 3 ways to use this library.**

### Lazy way
You just have to use a method:

```java
GlideToVectorYou.justLoadImage(activity, IMAGE_URI, targetImageView)
```

The svg will be automatically downloaded and inserted in your target Image View.

*Easy eh?*

### Normal way

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
                .load(Uri.parse(IMAGE_URL), imageview); 
```

Here you have more methods to customize the behaviour of *GlideToVectorYou*. You can for example:

* set a custom listener to respond to events with ```withListener()```
* show place holders while the image is loading or the loading failed with ```setPlaceHolder()```.


### Advanced way
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

### Licence
This library is shared under **Apache License 2.0**.

#### Made with ♥ by 2 Coffees 1 Tea(m).
