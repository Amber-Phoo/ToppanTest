import { AppSetting } from '../utils/AppSetting'
const axios = require('axios');
axios.defaults.headers.post['Access-Control-Allow-Origin'] = '*';

class BookDataService {

    getTop3ReadBooksGlobal = () => {
        return axios.get(`${AppSetting.BASE_URL}/getTop3ReadBooks`)
    };

    getTop3ReadBooksByCountry = (countryCode) => {
        return axios.get(`${AppSetting.BASE_URL}/getTop3ReadBooks?country_code=${countryCode}`)
    };

    getRandomCountry = () => {
        return axios.get(`${AppSetting.BASE_URL}/getRandomCountry`)
    };

}

const b=new BookDataService();
export default b;