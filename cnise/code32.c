//client
#include<stdio.h>
#include<sys/types.h>
#include<sys/socket.h>
#include<netinet/in.h>
#include<sys/fcntl.h>
#include<stdlib.h>
#include<string.h>
#include<arpa/inet.h>

int main(int argc,char *argv[])
{
int sockfd,portno,n;
struct sockaddr_in seradd;
char buffer[4096],*serip;
if(argc<4)
{
fprintf(stderr,"usage %s serverip filename port",argv[0]);
exit(0);
}
serip=argv[1];
portno=atoi(argv[3]);
sockfd=socket(AF_INET,SOCK_STREAM,0);
if(sockfd<0)
perror("\n Error in creating socket.\n");
perror("\n Client on line.");
bzero((char *)&seradd,sizeof(seradd));
seradd.sin_family=AF_INET;
seradd.sin_addr.s_addr=inet_addr(serip);
seradd.sin_port=htons(portno);
if(connect(sockfd,(struct sockaddr *)&seradd,sizeof(seradd))<0)
perror("\n Error in connection setup \n");
write(sockfd,argv[2],strlen(argv[2])+1);
bzero(buffer,4096);
n=read(sockfd,buffer,4096);
if(n<=0)
{
perror("\n File not found");
exit(0);
}
write (1,buffer,n);
}
