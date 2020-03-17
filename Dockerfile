FROM store/oracle/serverjre:1.8.0_241-b07
COPY ./out/production/HelloWorld/ /tmp
WORKDIR /tmp
CMD ["java", "MyApp"]