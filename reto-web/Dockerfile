# Fase de construcción
FROM node:lts-bullseye AS builder
WORKDIR /app

COPY package*.json ./
RUN npm ci
RUN npm install -g @angular/cli
COPY . .
RUN npm run build

# Fase de producción
FROM nginx:alpine
COPY config/default.conf /etc/nginx/conf.d/default.conf
COPY --from=builder /app/dist/reto-web /var/www/app/
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
