FROM golang:alpine
WORKDIR /go/src
RUN go mod init go
RUN go get github.com/gin-gonic/gin github.com/jinzhu/gorm
ADD src ./
CMD go run main.go