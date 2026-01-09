# FROM node:lts-alpine

# ## 컨테이너를 만들때 필수적X
# ## curl(client-url) 설치
# ## curl은 psotman 같은 url 요청을 날릴 수 있는 것
# ## curl이 필요할때만 사용하고 값을 저장하지 않게 하는 것(원래는 캐싱을 함 -> 사용 안할떄도 저장하고 있어서 컨테이너가 무거워짐)
# RUN apk add --no-cache curl

# WORKDIR /app

# COPY . .

# RUN npm install

# ## npm run dev --host 0.0.0.0
# ## --host 0.0.0.0은 네트워크 인터페이스에서 접속을 허용(Docker 컨테이너 외부의 아무 IP에서나 접속 가능)
# ##중간에 이중 대쉬(--)는 npm 명령어와 구분하기 위한 구분자
# CMD ["npm", "run", "dev", "--", "--host", "0.0.0.0"]

FROM node:lts-alpine AS build-stage
WORKDIR /app
COPY package*.json ./
RUN npm install
COPY . .
RUN npm run build
FROM nginx:stable-alpine AS production-stage
COPY --from=build-stage /app/dist /usr/share/nginx/html
COPY ./nginx.conf /etc/nginx/conf.d/default.conf
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]