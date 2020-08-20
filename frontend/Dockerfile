FROM node as builder
RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app
COPY package.json /usr/src/app/
RUN npm install
ADD ../frontend/src /usr/src/app/src
ADD ../frontend/public /usr/src/app/public
EXPOSE 3000
CMD ["npm", "start"]