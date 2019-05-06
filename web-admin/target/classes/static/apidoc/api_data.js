define({ "api": [
  {
    "type": "GET",
    "url": "/deleteAllImprovementPlan",
    "title": "删除所有提升和改善计划表信息",
    "name": "deleteAllImprovementPlan_______________",
    "group": "ImprovementPlan",
    "parameter": {
      "examples": [
        {
          "title": "Request_Example:",
          "content": "GET: /deleteAllImprovementPlan\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"删除所有提升和改善计划表成功\"}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/ImprovementPlanController.java",
    "groupTitle": "ImprovementPlan",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/deleteAllImprovementPlan"
      }
    ]
  },
  {
    "type": "GET",
    "url": "/deleteImprovementPlanById",
    "title": "删除指定提升和改善计划表信息",
    "name": "deleteImprovementPlanById_______________",
    "group": "ImprovementPlan",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "id",
            "description": "<p>指定提升和改善计划表记录id</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request_Example:",
          "content": "GET: /deleteImprovementPlanById\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"删除指定提升和改善计划表成功\"}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/ImprovementPlanController.java",
    "groupTitle": "ImprovementPlan",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/deleteImprovementPlanById"
      }
    ]
  },
  {
    "type": "GET",
    "url": "/getAllImprovementPlan",
    "title": "查询所有提升和改善计划表信息",
    "name": "getAllImprovementPlan_______________",
    "group": "ImprovementPlan",
    "parameter": {
      "examples": [
        {
          "title": "Request_Example:",
          "content": "GET: /getAllImprovementPlan\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"查询提升和改善计划表成功\",\"data\":[\n{\"id\":1,\"report_item_id\":0,\"year\":\"2019\",\"month\":\"5\",\"ok\":1,\"plan\":\"1\",\"remark\":\"1\",\"date\":\"2019-01\"},{\n\"id\":2,\"report_item_id\":0,\"year\":\"2019\",\"month\":\"5\",\"ok\":1,\"plan\":\"1\",\"remark\":\"1\",\"date\":\"2019-01\"}]}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/ImprovementPlanController.java",
    "groupTitle": "ImprovementPlan",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/getAllImprovementPlan"
      }
    ]
  },
  {
    "type": "Post",
    "url": "/insertImprovementPlan",
    "title": "插入提升和改善计划表信息",
    "name": "insertImprovementPlan_______________",
    "group": "ImprovementPlan",
    "parameter": {
      "examples": [
        {
          "title": "Request_Example:",
          "content": "{\n \"report_item_id\":0,\n \"year\":\"2019\",\n \"month\":\"5\",\n \"ok\":1,\n \"plan\":\"1\",\n \"remark\":\"1\",\n \"date\":\"2019-01\"\n }\nPOST: /insertImprovementPlan\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"插入提升和改善计划表成功\"}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/ImprovementPlanController.java",
    "groupTitle": "ImprovementPlan",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/insertImprovementPlan"
      }
    ]
  },
  {
    "type": "GET",
    "url": "/selectImprovementPlanById?id=",
    "title": "查询指定提升和改善计划表信息",
    "name": "selectImprovementPlanById_______________",
    "group": "ImprovementPlan",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "id",
            "description": "<p>指定提升和改善计划表记录id</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request_Example:",
          "content": "GET: /deleteImprovementPlanById?id=\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"查找指定提升和改善计划表成功\",\n\"data\":{\"id\":1,\"report_item_id\":0,\"year\":\"2019\",\"month\":\"5\",\"ok\":1,\"plan\":\"1\",\"remark\":\"1\",\"date\":\"2019-01\"}}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/ImprovementPlanController.java",
    "groupTitle": "ImprovementPlan",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/selectImprovementPlanById?id="
      }
    ]
  },
  {
    "type": "Post",
    "url": "/updateImprovementPlan",
    "title": "更新指定提升和改善计划表信息",
    "name": "updateImprovementPlan_______________",
    "group": "ImprovementPlan",
    "parameter": {
      "examples": [
        {
          "title": "Request_Example:",
          "content": "{\n \"id\":1,\n \"report_item_id\":0,\n \"year\":\"2019\",\n \"month\":\"5\",\n \"ok\":1,\n \"plan\":\"1\",\n \"remark\":\"1\",\n \"date\":\"2019-01\"\n }\nPOST: /updateImprovementPlan\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"更新提升和改善计划表成功\"}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/ImprovementPlanController.java",
    "groupTitle": "ImprovementPlan",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/updateImprovementPlan"
      }
    ]
  },
  {
    "type": "GET",
    "url": "/deleteAllMonthReport",
    "title": "删除所有月度总结报告表信息",
    "name": "deleteAllMonthReport______________",
    "group": "MonthReport",
    "parameter": {
      "examples": [
        {
          "title": "Request_Example:",
          "content": "GET: /deleteAllMonthReport\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"删除所有月度总结报告表成功\"}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/MonthReportController.java",
    "groupTitle": "MonthReport",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/deleteAllMonthReport"
      }
    ]
  },
  {
    "type": "GET",
    "url": "/deleteMonthReportById?id=",
    "title": "删除指定月度总结报告表信息",
    "name": "deleteMonthReportById______________",
    "group": "MonthReport",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "id",
            "description": "<p>指定 月度总结报告表记录id</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request_Example:",
          "content": "GET: /deleteMonthReportById?id=\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"删除指定月度总结报告表成功\"}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/MonthReportController.java",
    "groupTitle": "MonthReport",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/deleteMonthReportById?id="
      }
    ]
  },
  {
    "type": "GET",
    "url": "/getAllMonthReport",
    "title": "查询所有月度总结报告表信息",
    "name": "getAllMonthReport______________",
    "group": "MonthReport",
    "parameter": {
      "examples": [
        {
          "title": "Request_Example:",
          "content": "GET: /getAllMonthReport\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"查询所有月度总结报告表成功\",\"data\":[\n{\"id\":1,\n\"report_item_id\":0,\n\"year\":\"2019\",\n\"month\":\"5\",\"\n\"target\":1000.1,\n\"value\":2000.1,\n\"difference\":3000.1,\n\"measure\":\"1111\",\n\"experience\":\"111\",\n\"deficiency\":\"111\",\n\"evaluate\":\"111\",\n\"remark\":\"111\",\n\"date\":\"2019-01-01\"},\n{\"id\":2,\n\"report_item_id\":0,\n\"year\":\"2019\",\n \"month\":\"5\",\"\n \"target\":1000.1,\n \"value\":2000.1,\n \"difference\":3000.1,\n \"measure\":\"1111\",\n \"experience\":\"111\",\n \"deficiency\":\"111\",\n \"evaluate\":\"111\",\n \"remark\":\"111\",\n \"date\":\"2019-01-01\"}]}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/MonthReportController.java",
    "groupTitle": "MonthReport",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/getAllMonthReport"
      }
    ]
  },
  {
    "type": "Post",
    "url": "/insertMonthReport",
    "title": "插入月度总结报告表信息",
    "name": "insertMonthReport______________",
    "group": "MonthReport",
    "parameter": {
      "examples": [
        {
          "title": "Request_Example:",
          "content": "{\n\"report_item_id\":0,\n\"year\":\"2019\",\n\"month\":\"5\",\"\n\"target\":1000.1,\n\"value\":2000.1,\n\"difference\":3000.1,\n\"measure\":\"1111\",\n\"experience\":\"111\",\n\"deficiency\":\"111\",\n\"evaluate\":\"111\",\n\"remark\":\"111\",\n\"date\":\"2019-01-01\"\n }\nPOST: /insertMonthReport\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"插入月度总结报告表成功\"}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/MonthReportController.java",
    "groupTitle": "MonthReport",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/insertMonthReport"
      }
    ]
  },
  {
    "type": "GET",
    "url": "/selectMonthReportById?id=",
    "title": "查询指定月度总结报告表信息",
    "name": "selectMonthReportById______________",
    "group": "MonthReport",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "id",
            "description": "<p>指定月度总结报告表记录id</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request_Example:",
          "content": "GET: /selectMonthReportById?id=\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"查找指定月度总结报告表成功\",\n\"data\":{\"id\":1,\"report_item_id\":0,\"year\":\"2019\",\"month\":\"5\",\"ok\":1,\"plan\":\"1\",\"remark\":\"1\",\"date\":\"2019-01\"}}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/MonthReportController.java",
    "groupTitle": "MonthReport",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/selectMonthReportById?id="
      }
    ]
  },
  {
    "type": "Post",
    "url": "/updateMonthReport",
    "title": "更新指定月度总结报告表信息",
    "name": "updateMonthReport______________",
    "group": "MonthReport",
    "parameter": {
      "examples": [
        {
          "title": "Request_Example:",
          "content": "{\n\"id\":1,\n\"report_item_id\":0,\n\"year\":\"2019\",\n\"month\":\"5\",\"\n\"target\":1000.1,\n\"value\":2000.1,\n\"difference\":3000.1,\n\"measure\":\"1111\",\n\"experience\":\"111\",\n\"deficiency\":\"111\",\n\"evaluate\":\"111\",\n\"remark\":\"111\",\n\"date\":\"2019-01-01\"\n }\nPOST: /updateMonthReport\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"更新月度总结报告表成功\"}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/MonthReportController.java",
    "groupTitle": "MonthReport",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/updateMonthReport"
      }
    ]
  },
  {
    "type": "Post",
    "url": "/addReduceTarget",
    "title": "添加一条项目降低目标设置",
    "name": "addReduceTarget_____________",
    "group": "ReduceTarget",
    "parameter": {
      "examples": [
        {
          "title": "Request_Example:",
          "content": "{\n\"report_item_id\":1,\n\"year\":\"2018\",\n\"year_percent\":0,\n\"year_value\":5525.02,\n\"last_year_value\":0,\n\"asset_or_debt\":1\n}\nPOST: /addReduceTarget\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"添加一条记录成功\",\"data\":true}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/ReduceTargetController.java",
    "groupTitle": "ReduceTarget",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/addReduceTarget"
      }
    ]
  },
  {
    "type": "GET",
    "url": "/deleteReduceTarget",
    "title": "删除指定项目降低目标设置",
    "name": "deleteReduceTarget_____________",
    "group": "ReduceTarget",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "id",
            "description": "<p>指定项目降低目标设置id</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request_Example:",
          "content": "GET: /deleteReduceTarget?id=\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"根据id删除一条记录成功\",\"data\":true}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/ReduceTargetController.java",
    "groupTitle": "ReduceTarget",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/deleteReduceTarget"
      }
    ]
  },
  {
    "type": "GET",
    "url": "/queryReduceTarget?id=",
    "title": "查询指定项目降低目标设置表",
    "name": "queryReduceTarget______________",
    "group": "ReduceTarget",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "id",
            "description": "<p>指定项目降低目标设置id</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request_Example:",
          "content": "GET: /queryReduceTarget?id=\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"根据ID查询一条记录成功\",\n\"data\":{\"id\":208,\"report_item_id\":0,\"year\":\"\",\"year_percent\":0,\"year_value\":635184.75,\"last_year_value\":,\n  \"jan\":52932.062,\"feb\":52932.062,\"mar\":52932.062,\"apr\":52932.062,\"may\":52932.062,\"jun\":52932.062,\n  \"jul\":52932.062,\"aug\":52932.062,\"sept\":52932.062,\"oct\":52932.062,\"nov\":52932.062,\"dec\":52932.062,\n  \"asset_or_debt\":true}\n}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/ReduceTargetController.java",
    "groupTitle": "ReduceTarget",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/queryReduceTarget?id="
      }
    ]
  },
  {
    "type": "GET",
    "url": "/queryReduceTargets",
    "title": "查询所有项目降低目标设置",
    "name": "queryReduceTargets_____________",
    "group": "ReduceTargets",
    "parameter": {
      "examples": [
        {
          "title": "Request_Example:",
          "content": "GET: /queryReduceTargets\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n{\"code\":0,\"message\":\"查询提升和改善计划表成功\",\"data\":[\n{\"id\":208,\"report_item_id\":0,\"year\":\"\",\"year_percent\":0,\"year_value\":635184.75,\"last_year_value\":,\n  \"jan\":52932.062,\"feb\":52932.062,\"mar\":52932.062,\"apr\":52932.062,\"may\":52932.062,\"jun\":52932.062,\n  \"jul\":52932.062,\"aug\":52932.062,\"sept\":52932.062,\"oct\":52932.062,\"nov\":52932.062,\"dec\":52932.062,\n  \"asset_or_debt\":true},\n{\"id\":209,\"report_item_id\":0,\"year\":\"\",\"year_percent\":0,\"year_value\":1000,\"last_year_value\":,\n  \"jan\":83.3333,\"feb\":583.3333,\"mar\":83.3333,\"apr\":83.3333,\"may\":83.3333,\"jun\":83.3333,\n  \"jul\":83.3333,\"aug\":83.3333,\"sept\":83.3333,\"oct\":83.3333,\"nov\":83.3333,\"dec\":83.3333,\n  \"asset_or_debt\":true}]\n}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/ReduceTargetController.java",
    "groupTitle": "ReduceTargets",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/queryReduceTargets"
      }
    ]
  },
  {
    "type": "post",
    "url": "/updateReduceTarget",
    "title": "更改指定项目降低目标设置",
    "name": "updateReduceTarget_____________",
    "group": "ReduceTarget",
    "parameter": {
      "examples": [
        {
          "title": "Request_Example:",
          "content": "{\n\"id\":238,\n\"year_value\":635184.7500\n}\nPOST: /updateReduceTarget\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"更新提升和改善计划表成功\",\"data\":true}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/ReduceTargetController.java",
    "groupTitle": "ReduceTarget",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/updateReduceTarget"
      }
    ]
  },
  {
    "type": "Post",
    "url": "/updateReduceTargets",
    "title": "批量更改项目降低目标设置",
    "name": "updateReduceTargets_____________",
    "group": "ReduceTarget",
    "parameter": {
      "examples": [
        {
          "title": "Request_Example:",
          "content": "[\n{\"id\":237,\"year_value\":5000},\n{\"id\":238,\"year_value\":5000},\n{\"id\":239,\"year_value\":5000}\n]\nPOST: /updateReduceTargets\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"批量更新成功\",\"data\":true}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/ReduceTargetController.java",
    "groupTitle": "ReduceTarget",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/updateReduceTargets"
      }
    ]
  },
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
