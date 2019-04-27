define({ "api": [
  {
    "type": "GET",
    "url": "/incomes/2018-07",
    "title": "计算损益表的年月金额",
    "name": "getIncome_________",
    "group": "api",
    "parameter": {
      "examples": [
        {
          "title": "Request_Example:",
          "content": "GET: /incomes\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"查询成功\",\"data\":[{\"id\":0,\"income_id\":1,\"year\":2018,\"month\":07,\"month_amount\":19888,\"year_amount\":89998,\"create_date\":2019-04-18}]}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/IncomeController.java",
    "groupTitle": "api",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/incomes/2018-07"
      }
    ]
  },
  {
    "type": "GET",
    "url": "/orders",
    "title": "查询订单信息",
    "name": "queryAll_______",
    "group": "api",
    "parameter": {
      "examples": [
        {
          "title": "Request_Example:",
          "content": "GET: /orders\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"查询订单成功\",\"data\":[{\"id\":1,\"name\":\"order1\",\"goodsNum\":1},{\"id\":2,\"name\":\"order2\",\"goodsNum\":2}]}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/OrderController.java",
    "groupTitle": "api",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/orders"
      }
    ]
  },
  {
    "type": "GET",
    "url": "/update",
    "title": "修改损益表结构",
    "name": "update",
    "group": "api",
    "parameter": {
      "examples": [
        {
          "title": "Request_Example:",
          "content": "GET: /orders\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"修改成功\",\"data\"}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/IncomeController.java",
    "groupTitle": "api",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/update"
      }
    ]
  }
] });