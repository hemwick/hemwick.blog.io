/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50710
Source Host           : localhost:3306
Source Database       : blog

Target Server Type    : MYSQL
Target Server Version : 50710
File Encoding         : 65001

Date: 2019-09-19 09:24:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `content` text,
  `intro` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT '1',
  `hits` int(11) DEFAULT '0',
  `comment` int(11) DEFAULT '1',
  `created` varchar(255) DEFAULT NULL,
  `updated` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('4', 'Java学习', '# JDK环境配置\n## JAVA_HOME：JDK安装路径', 'Java基础环境搭建', '1', '0', '1', '2019-09-16 11:43:01', null);
INSERT INTO `article` VALUES ('5', 'test', 'test\'test', 'test', '2', '0', '1', '2019-09-16 13:38:21', null);
INSERT INTO `article` VALUES ('6', '123123', '123123', '123123', '1', '0', '1', '2019-09-16 14:00:05', null);
INSERT INTO `article` VALUES ('7', '321321', '312312', '321321', '2', '0', '1', '2019-09-16 14:00:33', null);
INSERT INTO `article` VALUES ('8', '母猪的产后护理', '母猪的产后护理', '母猪的产后护理', '1', '0', '1', '2019-09-16 14:43:20', null);
INSERT INTO `article` VALUES ('9', '沉默的羔羊', '# 沉默的羔羊', '沉默的羔羊', '1', '0', '1', '2019-09-16 14:44:05', null);
INSERT INTO `article` VALUES ('10', '沉落的黄昏', null, '嗷', '1', '0', '1', '2019-09-17 10:29:26', null);
INSERT INTO `article` VALUES ('11', '论捧逗', null, '论捧逗', '1', '0', '1', '2019-09-17 10:29:52', null);
INSERT INTO `article` VALUES ('16', '关闭评论', null, '关闭评论', '1', '0', '2', '2019-09-17 11:23:29', null);
INSERT INTO `article` VALUES ('17', '关闭评论', null, '关闭评论', '1', '0', '1', '2019-09-17 11:25:43', null);
INSERT INTO `article` VALUES ('18', '测试文章内容', '测试文章内容测试文章内容测试文章内容测试文章内容测试文章内容测试文章内容测试文章内容测试文章内容测试文章内容测试文章内容测试文章内容测试文章内容测试文章内容测试文章内容测试文章内容测试文章内容测试文章内容测试文章内容测试文章内容测试文章内容测试文章内容', '测试文章内容', '1', '0', '1', '2019-09-17 11:42:12', null);
INSERT INTO `article` VALUES ('19', '迦勒底唯一指定枪兵', '# 迦勒底唯一指定枪兵\n[![](http://localhost:8080/blog/upload/20190917000912607035.jpg)](http://localhost:8080/blog/upload/20190917000912607035.jpg)', '迦勒底唯一指定枪兵', '1', '0', '1', '2019-09-17 11:42:55', null);
INSERT INTO `article` VALUES ('20', '理解TCP/IP三次握手与四次挥手的正确姿势', '# 三次握手的举例\n我：1+1等于几？\n\n她：2,2+2等于几？\n\n我：4\n\n首先两个人约定协议\n\n1.感觉网络情况不对的时候，任何一方都可以发起询问\n\n2.任何情况下，若发起询问后5秒还没收到回复，则认为网络不通\n\n3.网络不通的情况下等1min路由器之后再发起询问\n\n\n\n对于我而言，发起 “1+1等于几”的询问后\n\n1. 若5s内没有收到回复，则认为网络不通\n\n2. 若收到回复，则我确认①我能听到她的消息 ②她能听到我的消息，然后回复她的问题的答案\n\n\n对于她而言，当感觉网络情况不对的时候\n\n1. 若没有收到我的询问，则她发起询问\n\n2. 若收到“1+1等于几”，则她确认 ①她可以听到我的消息，然后回复我的问题的答案和她的问题“2，2+2等于几”\n\n3. 若5s内没有收到我的回复“4”，则她确认 ②我听不见她的消息\n\n4. 若5s内收到了我的回复“4”，则她确认 ②我可以听见她的消息\n\n这样，如果上面的对话得以完成，就证明双方都可以确认自己可以听到对方的声音，对方也可以听到自己的声音！\n\n这个故事可以解释TCP为什么要三次握手吗 ... 囧\n\n关于四次挥手\n\n先由客户端向服务器端发送一个FIN，请求关闭数据传输。\n\n当服务器接收到客户端的FIN时，向客户端发送一个ACK，其中ack的值等于FIN+SEQ\n\n然后服务器向客户端发送一个FIN，告诉客户端应用程序关闭。\n\n当客户端收到服务器端的FIN是，回复一个ACK给服务器端。其中ack的值等于FIN+SEQ\n\n\n\n\n\n# 为什么要4次挥手？\n\n确保数据能够完整传输。', '理解TCP/IP三次握手与四次挥手的正确姿势', '1', '0', '1', '2019-09-18 22:36:45', null);
INSERT INTO `article` VALUES ('21', '2019JAVA面试题附答案', '# ArrayList 和 LinkedList 有什么区别。\nArrayList和LinkedList都实现了List接口，有以下的不同点：\n1、ArrayList是基于索引的数据接口，它的底层是数组。它可以以O(1)时间复杂度对元素进行随机访问。与此对应，LinkedList是以元素列表的形式存储它的数据，每一个元素都和它的前一个和后一个元素链接在一起，在这种情况下，查找某个元素的时间复杂度是O(n)。\n2、相对于ArrayList，LinkedList的插入，添加，删除操作速度更快，因为当元素被添加到集合任意位置的时候，不需要像数组那样重新计算大小或者是更新索引。\n3、LinkedList比ArrayList更占内存，因为LinkedList为每一个节点存储了两个引用，一个指向前一个元素，一个指向下一个元素。\n\n# 讲讲类的实例化顺序，比如父类静态数据，构造函数，字段，子类静态数据，构造函数，字段，当 new 的时候， 他们的执行顺序。\n此题考察的是类加载器实例化时进行的操作步骤（加载–>连接->初始化）。\n父类静态代变量、\n父类静态代码块、\n子类静态变量、\n子类静态代码块、\n父类非静态变量（父类实例成员变量）、\n父类构造函数、\n子类非静态变量（子类实例成员变量）、\n子类构造函数。\n\n#用过哪些 Map 类，都有什么区别，HashMap 是线程安全的吗,并发下使用的 Map 是什么，他们内部原理分别是什么，比如存储方式， hashcode，扩容， 默认容量等。\nhashMap是线程不安全的，HashMap是数组+链表+红黑树（JDK1.8增加了红黑树部分）实现的，采用哈希表来存储的，', '2019JAVA面试题附答案', '1', '0', '1', '2019-09-18 22:38:18', null);
INSERT INTO `article` VALUES ('22', 'Bootstrap插件', 'Bootstrap插件概览 站点引用 Bootstrap 插件的方式有两种： 单独引用：使用 Bootstrap 的个别的 *.js 文件。一些插件和 CSS 组件依赖于其他插件。如果您单独引用插件，请先确保弄清这些插件之间的依赖关系。 编译（同时）引用：使用 bootstrap.js 或压缩版的 bootstrap.min.js。 （API:应用程序接口） data 属性： 通过 data 属性 API 就能使用所有的 Bootstrap 插件，无需写一行 JavaScript 代码。首选方式 关闭 data 属性 API 的方法，即解除以 data-api 为命名空间并绑定在文档上的事件。`(document).off(‘.data−api′)‘关闭一个特定的插件，只需要在data−api命名空间前加上该插件的名称作为命名空间即可。‘(document).off(‘.alert.data-api’)` 编程方式的 API 避免命名空间冲突：可以通过调用插件的 .noConflict 方法恢复其原始值。\nvar bootstrapButton = $.fn.button.noConflict() // 返回 $.fn.button 之前所赋的值\n$.fn.bootstrapBtn = bootstrapButton// 为 $().bootstrapBtn 赋予 Bootstrap 功能\n事件两种形式： 动词不定式：这会在事件开始时被触发。动词不定式事件提供了 preventDefault 功能。这使得在事件开始前可以停止操作的执行。\n$(\'#myModal\').on(\'show.bs.modal\', function (e) {\n  if (!data) return e.preventDefault() \n})\n过去分词形式：这会在动作执行完毕之后被触发。例如 ex: shown。 一、过渡效果（Transition）插件 1、模态框（Modal）插件 模态框（Modal）是覆盖在父窗体上的子窗体。通常，目的是显示来自一个单独的源的内容，可以在不离开父窗体的情况下有一些互动。子窗体可提供信息、交互等。 切换模态框（Modal）插件的隐藏内容： 通过 data 属性： 在控制器元素（比如按钮或者链接）上设置属性 data-toggle=”modal”，同时设置 data-target=”#identifier” 或 href=”#identifier” 来指定要切换的特定的模态框（带有 id=”identifier”）。 通过 JavaScript： 使用这种技术，您可以通过简单的一行 JavaScript 来调用带有 id=”identifier” 的模态框：\n$(\'#identifier\').modal(options)\n选项 backdrop boolean 或 string ‘static’ 默认值：true data-backdrop 指定一个静态的背景，当用户点击模态框外部时不会关闭模态框。 keyboard boolean 默认值：true data-keyboard 当按下 escape 键时关闭模态框，设置为 false 时则按键无效。 show boolean 默认值：true data-show 当初始化时显示模态框。 remote path 默认值：false data-remote 使用 jQuery .load 方法，为模态框的主体注入内容。如果添加了一个带有有效 URL 的 href，则会加载其中的内容。 方法：与 modal() 一起使用的有用的方法。 Options: .modal(options) 把内容作为模态框激活。接受一个可选的选项对象。', 'bootstrap插件问题', '1', '0', '1', '2019-09-18 22:39:42', null);
INSERT INTO `article` VALUES ('23', '使用bootstrapvalidator的remote验证经验', '```java\nremote: {//ajax验证。server result:{\"valid\",true or false} 向服务发送当前input name值，获得一个json数据。例表示正确：{\"valid\",true}  \n                         url: \'exist2.do\',//验证地址\n                         message: \'用户已存在\',//提示消息\n                         delay :  2000,//每输入一个字符，就发ajax请求，服务器压力还是太大，设置2秒发送一次ajax（默认输入一个字符，提交一次，服务器压力太大）\n                         type: \'POST\'//请求方式\n                         /**自定义提交数据，默认值提交当前input value\n                          *  data: function(validator) {\n                               return {\n                                   password: $(\'[name=\"passwordNameAttributeInYourForm\"]\').val(),\n                                   whatever: $(\'[name=\"whateverNameAttributeInYourForm\"]\').val()\n                               };\n                            }\n                          */\n                     },\n```', '使用bootstrapvalidator的remote验证经验', '1', '0', '1', '2019-09-18 22:42:00', null);

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', 'Java', null);
INSERT INTO `category` VALUES ('2', 'Spring', null);
INSERT INTO `category` VALUES ('3', 'SpringMVC', null);
INSERT INTO `category` VALUES ('4', 'Mybatis', null);
INSERT INTO `category` VALUES ('5', 'PHP', null);
INSERT INTO `category` VALUES ('6', 'Python', null);
INSERT INTO `category` VALUES ('7', 'HTML', null);
INSERT INTO `category` VALUES ('8', 'CSS', null);
INSERT INTO `category` VALUES ('9', 'JS', null);
INSERT INTO `category` VALUES ('10', 'JQuery', null);
INSERT INTO `category` VALUES ('11', 'Bootstrap', null);
INSERT INTO `category` VALUES ('15', 'Ajax', '');
INSERT INTO `category` VALUES ('16', 'R', '');
INSERT INTO `category` VALUES ('17', 'HTTP', '');

-- ----------------------------
-- Table structure for category_article
-- ----------------------------
DROP TABLE IF EXISTS `category_article`;
CREATE TABLE `category_article` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `aid` int(11) DEFAULT NULL,
  `cid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category_article
-- ----------------------------
INSERT INTO `category_article` VALUES ('6', '4', '4');
INSERT INTO `category_article` VALUES ('7', '4', '3');
INSERT INTO `category_article` VALUES ('8', '4', '2');
INSERT INTO `category_article` VALUES ('9', '4', '1');
INSERT INTO `category_article` VALUES ('10', '5', '16');
INSERT INTO `category_article` VALUES ('11', '5', '15');
INSERT INTO `category_article` VALUES ('12', '5', '11');
INSERT INTO `category_article` VALUES ('13', '6', '11');
INSERT INTO `category_article` VALUES ('14', '7', '10');
INSERT INTO `category_article` VALUES ('15', '8', '5');
INSERT INTO `category_article` VALUES ('16', '9', '11');
INSERT INTO `category_article` VALUES ('17', '10', '2');
INSERT INTO `category_article` VALUES ('18', '11', '9');
INSERT INTO `category_article` VALUES ('19', '12', '6');
INSERT INTO `category_article` VALUES ('20', '13', '6');
INSERT INTO `category_article` VALUES ('21', '14', '6');
INSERT INTO `category_article` VALUES ('22', '15', '16');
INSERT INTO `category_article` VALUES ('23', '16', '11');
INSERT INTO `category_article` VALUES ('24', '17', '16');
INSERT INTO `category_article` VALUES ('25', '18', '5');
INSERT INTO `category_article` VALUES ('26', '18', '3');
INSERT INTO `category_article` VALUES ('27', '18', '2');
INSERT INTO `category_article` VALUES ('28', '19', '15');
INSERT INTO `category_article` VALUES ('29', '19', '10');
INSERT INTO `category_article` VALUES ('30', '19', '9');
INSERT INTO `category_article` VALUES ('31', '20', '17');
INSERT INTO `category_article` VALUES ('32', '21', '1');
INSERT INTO `category_article` VALUES ('33', '22', '11');
INSERT INTO `category_article` VALUES ('34', '23', '11');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `content` text,
  `aid` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT '1',
  `created` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('1', '方正', '顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶顶', '19', '1', '2019-09-17 14:07:03');
INSERT INTO `comment` VALUES ('2', '123', '123', '19', '1', '2019-09-17 14:09:01');
INSERT INTO `comment` VALUES ('3', '留言噢', '留言留言', '19', '1', '2019-09-17 14:10:13');
INSERT INTO `comment` VALUES ('4', 'adasda', '撒大苏打大苏打大大', '19', '1', '2019-09-17 14:10:32');
INSERT INTO `comment` VALUES ('5', '啊大苏打的', '啊顺德区人情味请问日期太前卫前卫的飒飒', '19', '1', '2019-09-17 14:10:43');
INSERT INTO `comment` VALUES ('6', '儿童趣味', '而且我提前释放求为求为沙雕锅确人情味而且实大地区无人人给的分求为去', '19', '1', '2019-09-17 14:10:58');
INSERT INTO `comment` VALUES ('7', '求为恰过是的噶求', '啊实打实的和技术卡的规范会计和u维埃拉还发生了很多俘虏会和老大发话了uaf uhkaulf', '19', '1', '2019-09-17 14:11:14');
INSERT INTO `comment` VALUES ('8', '吃泡面', '吃泡面吃泡面吃泡面吃泡面吃泡面吃泡面吃泡面吃泡面吃泡面吃泡面吃泡面吃泡面吃泡面吃泡面吃泡面吃泡面吃泡面', '19', '1', '2019-09-17 14:11:27');
INSERT INTO `comment` VALUES ('10', '10', '10101010101010101010101010101010101010101010101010101010101010', '19', '2', '2019-09-17 14:12:47');
INSERT INTO `comment` VALUES ('11', '十一', '十一十一十一十一十一十一十一十一十一十一十一十一十一十一十一十一十一十一十一十一十一十一十一十一', '19', '2', '2019-09-17 14:12:54');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `realname` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '21232f297a57a5a743894a0e4a801fc3', 'admin', '13218090371');
INSERT INTO `user` VALUES ('2', '22222', 'c81e728d9d4c2f636f067f89cc14862c', '2', '13218090371');
INSERT INTO `user` VALUES ('3', '33333', '3', '3', '3');
INSERT INTO `user` VALUES ('4', '44444', '4', '4', '4');
INSERT INTO `user` VALUES ('5', '55555', '5', '5', '5');
INSERT INTO `user` VALUES ('6', '666666', '6', '66', '6');
INSERT INTO `user` VALUES ('7', '777777', '7', '7', '7');
INSERT INTO `user` VALUES ('8', '88888', '8', '8', '8');
INSERT INTO `user` VALUES ('9', '99999', '9', '9', '9');
INSERT INTO `user` VALUES ('10', '10000', '101', '10', '10');
INSERT INTO `user` VALUES ('14', '', null, '', null);
INSERT INTO `user` VALUES ('15', '', '12', '', '');
INSERT INTO `user` VALUES ('16', '12312', '321321', '321321', '321321321');
INSERT INTO `user` VALUES ('17', '131321', '321321', '321321', '321321');
INSERT INTO `user` VALUES ('18', '22222', '12', '12', '13218090371');
INSERT INTO `user` VALUES ('19', '22222', '222', 'FZ', '13218090371');
