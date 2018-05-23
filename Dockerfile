FROM johnpapa/angular-cli
WORKDIR /
COPY b2c-frontend /
CMD ["cd /b2c-frontend"]
ENTRYPOINT ng serve
EXPOSE 4200
