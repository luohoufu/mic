## 项目开发过程
参考：[spring cloud & spring boot](http://projects.spring.io/spring-cloud/#quick-start)

## 配置iTerm2 和 Oh-My-Zsh

## 下载JDK和Maven

### 个性Maven配置
``` xml
<localRepository>/Users/luohoufu/repo</localRepository>
<mirror>
    <id>nexus-aliyun</id>
    <mirrorOf>*</mirrorOf>
    <name>Nexus aliyun</name>
    <url>http://maven.aliyun.com/nexus/content/groups/public</url>
</mirror>
``` 

### 创建项目
``` bash
java -version
mvn -v
mkdir ~/mic && cd ~/mic
touch README.md
mvn archetype:generate -DgroupId=io.tonny -DartifactId=mic -Dversion=1.0.0-SNAPSHOT -Dpackage=io.tonny -DarchetypeArtifactId=maven-archetype-site-simple -DarchetypeGroupId=org.apache.maven.archetypes  -DinteractiveMode=false -DarchetypeCatalog=local

mv mic/pom.xml .
rm -rf ./mic

mvn archetype:generate -DgroupId=io.tonny -DartifactId=mic-registry-server -Dversion=1.0.0-SNAPSHOT -Dpackage=io.tonny -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeGroupId=org.apache.maven.archetypes  -DinteractiveMode=false -DarchetypeCatalog=local
mvn archetype:generate -DgroupId=io.tonny -DartifactId=mic-config-server -Dversion=1.0.0-SNAPSHOT -Dpackage=io.tonny -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeGroupId=org.apache.maven.archetypes  -DinteractiveMode=false -DarchetypeCatalog=local
mvn archetype:generate -DgroupId=io.tonny -DartifactId=mic-portal-service -Dversion=1.0.0-SNAPSHOT -Dpackage=io.tonny -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeGroupId=org.apache.maven.archetypes  -DinteractiveMode=false -DarchetypeCatalog=local

# 设置忽略文件
touch .gitignore 

```

### 修改顶级pom.xml
``` xml
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>1.5.2.RELEASE</version>
</parent>
<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-dependencies</artifactId>
            <version>Dalston.RELEASE</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>
```

### 个性registry-server的pom.xml
``` xml
<dependencies>
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-eureka-server</artifactId>
    </dependency>
</dependencies>
```

### 个性config-server的pom.xml
``` xml
<dependencies>
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-config-server</artifactId>
    </dependency>
</dependencies>
```

### Git项目配置
``` bash
brew install git xclip

git config --global user.name "Tonny.Luo"
git config --global user.email "luohoufu@163.com"
git config --global --list

ssh-keygen -t rsa -C "luohoufu@163.com"
xclip -selection c  ~/.ssh/id_rsa.pub
#登录github并访问[SSH and GPG keys](https://github.com/settings/keys),粘贴ssh key.

ssh git@github.com
#PTY allocation request failed on channel 0
#Hi luohoufu! You've successfully authenticated, but GitHub does not provide shell access.
#Connection to github.com closed.

# 访问 [new repository](https://github.com/new)
# 创建一个空的项目，然后再将本的项目上传，采用MIT协议

git init
git add .
git commit -m ‘项目目初始化’
git remote add origin git@github.com:luohoufu/mic.git


git pull origin master --allow-unrelated-histories
git branch --set-upstream-to=origin/master master
git push -u origin master

# 创建开发分支
git branch dev
git checkout dev
git commit -am '修改README.md配置'
git push origin dev:dev
#git push origin :dev 删除分支
```