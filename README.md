# ToppanTest by Aye Mya Phoo

FrontEnd(ReactJS) and BackEnd(Java Spring Boot)

## Deployment
(Requires docker and docker compose to be installed)

The current IP address or the hostname of the docker host is required for the following steps. 
As my local ip address is `192.168.0.120` I'll be using this as the example. Replace this with the IP address or hostname of the docker host.

<p>&nbsp;</p>

To point the React App to correct backend, edit the file: 
```
Frontend/react_frontend_toppan/src/utils/AppSetting.js
```

And change it to:
```
export const AppSetting = {
    BASE_URL: "http://192.168.0.120:8080/api",
};
```

<p>&nbsp;</p>


From the main directory (the one with docker-compose.yml file) run the command:
```docker compose build```

Once complete, run:
```docker compose up -d```

React will be running port `3000` accessed by host IP adress. In my case, it's `http://192.168.0.120:3000/`

Run from Docker Desktop (Optional)

![image](https://user-images.githubusercontent.com/100519215/230719810-f4ec4fbc-94a5-4089-a1a9-0b10291560da.png)


