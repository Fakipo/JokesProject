FROM node:14-alpine

WORKDIR /app

ARG REACT_APP_BACKEND_WEBSERVICE


ENV REACT_APP_BACKEND_WEBSERVICE $REACT_APP_BACKEND_WEBSERVICE


COPY package*.json ./

RUN npm install

COPY . .

RUN npm run build

RUN npm install -g serve

ENV NODE_ENV=production

EXPOSE 3000

CMD ["serve", "-s", "build", "-l", "3000"]
