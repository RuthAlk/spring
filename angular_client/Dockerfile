# Use an official Node.js image as the base image
FROM node:latest AS build

# Set the working directory within the container
WORKDIR /app

# Copy package.json and package-lock.json to the container
COPY package*.json ./

# Install project dependencies
RUN npm install

# Copy the rest of the application files to the container
COPY . .

# Build the Angular app
RUN npm run build -- --configuration=production

# Use a lightweight nginx image as the final image
FROM nginx:alpine

# Copy the built Angular app to the nginx public directory
COPY --from=build /app/dist/my-app /usr/share/nginx/html

EXPOSE 80
