package middlewares

import (
	"io/ioutil"
	"net/http"
)

func HttpGet(url string, accept bool) string {
	req, err := http.NewRequest("GET", url, nil)
	if err != nil {
		panic(err)
	}

	if accept {
		req.Header.Add("Accept", "application/json")
	}

	client := &http.Client{}
	res, err := client.Do(req)
	if err != nil {
		panic(err)
	}

	defer res.Body.Close()
	bytes, _ := ioutil.ReadAll(res.Body)
	str := string(bytes)
	return str
}

func HttpPost() string {
	return "NOT POST IMPLEMENT"
}

func HttpPut() string {
	return "NOT PUT IMPLEMENT"
}

func HttpDelete() string {
	return "NOT DELETE IMPLEMENT"
}
