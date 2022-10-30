# Google Place Nearby Search API Documentation

[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://travis-ci.org/joemccann/dillinger)

This project basically processes the given latitude, longitude and radius information via Google Place API and returns a list of nearby places. If the given latitude, longitude and radius information is stored in the Project database, the results return from the database instead of consulting the API again.

Technologies Used in the Project.

* Java 17
* Spring boot 2.6.7
* Maven
* Mongo DB (Cloud)
* Logback
* Validation (Javax & Custom Validation)
* Aspect Oriented Programming (JAspect)
* Swagger
* Google Place API
* Lombok
* Mapstruct

## Project Usage guide ##

The project was developed to run on port 8070. In the .gitignore file all configuration and property files are excluded. People or organizations that want to clone and use the project as public must prepare their own application.yml files.

In order for the project to serve its purpose, the Place API KEY must be obtained by Google Developer Cloud and placed in the api apiKey and placeApiUrl fields under the api root in the .yml file.

``` yml
api:
  placeApiUrl: https://maps.googleapis.com/maps/api/place/nearbysearch/json?
  apiKey: secret
```


```localhost:8070/getPlaces```
to endpoint ;
| field     | type   | validation                         | Error Message                |
|-----------|--------|------------------------------------|------------------------------|
| latitude*  | double | min = - 90 ,max = 90. \| Not Null  | null : 0004 constraint: 0005 |
| longitude* | double | min = - 180 ,max = 180 \| Not Null | null : 0006 constraint: 0008 |
| radius*    | double | min = 0. \| Not Null               | null : 0009 constraint: 0011 |

When you send a request according to the values in the given table, you will receive a sample response as below.

```json
{
  "results": [
    {
      "geometry": {
        "location": {
          "lat": 35.989011,
          "lng": 36.001647
        },
        "viewport": {
          "northeast": {
            "lat": 35.99140236319293,
            "lng": 36.00640370633941
          },
          "southwest": {
            "lat": 35.98572218012063,
            "lng": 35.99688070648632
          }
        }
      },
      "icon": "https://maps.gstatic.com/mapfiles/place_api/icons/v1/png_71/geocode-71.png",
      "icon_background_color": "#7B9EB0",
      "icon_mask_base_uri": "https://maps.gstatic.com/mapfiles/place_api/icons/v2/generic_pinlet",
      "name": "Gözlüce",
      "photos": [
        {
          "height": 922,
          "html_attributions": [
            "<a href=\"https://maps.google.com/maps/contrib/113703010473257749688\">Hatay Hayat</a>"
          ],
          "photo_reference": "AcYSjRgvxnmV434jz7f2-BdQe0-kscJlxxUC5ZxpimsYAVckL4HkMN8xK1kcbG3cEsh6JEhiUBn-0PFv3XQpLLHH29M8qzJmOdSMN-iOUK7R8B1u0F3TtWEMiwrHrbQlO_MOn7gpFYvWO9SM3mzN5raDURVQiDYeiyLgDjGoHJZzR5YlSocF",
          "width": 738
        }
      ],
      "place_id": "ChIJQ3n7E6ksJBURNkok8foCiLE",
      "reference": "ChIJQ3n7E6ksJBURNkok8foCiLE",
      "scope": "GOOGLE",
      "types": [
        "locality",
        "political"
      ],
      "vicinity": "Gözlüce"
    },
  ],
  "status": "OK",
}
```

In case of a problem, you can contact us via Linkedin. https://www.linkedin.com/in/ulasmuezzinoglu

#### Notes ####
Dockerize steps
The project has its own Dockerfile. When requested,
```
docker build . -t <RepoName:TAGNAME>
```
you can create an image with this code, you can also create a container with
```
docker run -it -d -p 8070:8070
```
code and run / Deploy it on your local machine.
