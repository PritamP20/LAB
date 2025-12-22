//server
#include<stdio.h>
#include<sys/types.h>
#include<sys/socket.h>
#include<netinet/in.h>
#include<sys/fcntl.h>
#include<stdlib.h>
int main(int argc,char *argv[])
{
int fd,sockfd,newsockfd,clilen,portno,n;
struct sockaddr_in seradd,cliadd;
char buffer[4096];
if(argc<2)
{
fprintf(stderr,"\n\n No port\n");
exit(1);
}
portno=atoi(argv[1]);
sockfd=socket(AF_INET,SOCK_STREAM,0);
if(sockfd<0)
error("\n error opening socket.\n");
bzero((char *)&seradd,sizeof(seradd));
seradd.sin_family=AF_INET;
seradd.sin_addr.s_addr=(htonl)INADDR_ANY;
seradd.sin_port=htons(portno);
if(bind(sockfd,(struct sockaddr *)&seradd,sizeof(seradd))<0)
perror("\n IP addr cannt bind");
listen(sockfd,5);
clilen=sizeof(cliadd);
printf("\n Server waiting for clint request\n");
while(1)
{
newsockfd=accept(sockfd,(struct sockaddr *)&cliadd,&clilen);
if(newsockfd<0)
perror("\n Server cannot accept connection request ");
bzero(buffer,4096);
read(newsockfd,buffer,4096);
fd=open(buffer,O_RDONLY);
if(fd<0)
perror("\n File  doesnot exist");
while(1)
{
n=read(fd,buffer,4096);
if(n<=0)
exit(0);
write(newsockfd,buffer,n);
printf("\n File transfer completet\n");
}
close(fd);
close(newsockfd);
}
return 0;}