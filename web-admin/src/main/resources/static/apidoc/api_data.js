define({ "api": [
  {
    "type": "DELETE",
    "url": "/deleteAllImprovementPlan",
    "title": "删除所有提升和改善计划表信息",
    "name": "deleteAllImprovementPlan_______________",
    "group": "ImprovementPlan",
    "parameter": {
      "examples": [
        {
          "title": "Request_Example:",
          "content": "DELETE: /deleteAllImprovementPlan\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
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
    "type": "DELETE",
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
          "content": "DELETE: /deleteImprovementPlanById?id=1\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
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
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"查询提升和改善计划表成功\",\n\"data\":[\n         {\n             \"id\":1,\n             \"report_item_id\":0,\n             \"year\":\"2019\",\n             \"month\":\"5\",\n             \"ok\":1,\n             \"plan\":\"1\",\n             \"remark\":\"1\",\n             \"create_date\":\"2019-01-01 00:00:00\"},\n         {\n             \"id\":2,\n             \"report_item_id\":0,\n             \"year\":\"2019\",\n             \"month\":\"5\",\n             \"ok\":1,\n             \"plan\":\"1\",\n             \"remark\":\"1\",\n             \"create_date\":\"2019-01-01 00:00:00\"\n           }\n      ]}",
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
    "type": "POST",
    "url": "/insertImprovementPlan",
    "title": "插入提升和改善计划表信息",
    "name": "insertImprovementPlan_______________",
    "group": "ImprovementPlan",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "bigint",
            "optional": false,
            "field": "report_item_id",
            "description": "<p>报告条目id</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "year",
            "description": "<p>年度</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "month",
            "description": "<p>月份</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "ok",
            "description": "<p>完成情况</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "plan",
            "description": "<p>改善计划</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "remark",
            "description": "<p>备注</p>"
          },
          {
            "group": "Parameter",
            "type": "Timestamp",
            "optional": false,
            "field": "create_date",
            "description": "<p>创建时间</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request_Example:",
          "content": "{\n \"report_item_id\":0,\n \"year\":\"2019\",\n \"month\":\"5\",\n \"ok\":1,\n \"plan\":\"1\",\n \"remark\":\"1\",\n \"create_date\":\"2019-01-01 00:00:00\"\n }\nPOST: /insertImprovementPlan\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
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
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\n\"message\":\"查找指定提升和改善计划表成功\",\n\"data\":{\"id\":1,\n\"report_item_id\":0,\n\"year\":\"2019\",\n\"month\":\"5\",\n\"ok\":1,\n\"plan\":\"1\",\n\"remark\":\"1\",\n\"create_date\":\"2019-01-01 00:00:00\"}}",
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
    "type": "PUT",
    "url": "/updateImprovementPlan",
    "title": "更新指定提升和改善计划表信息",
    "name": "updateImprovementPlan_______________",
    "group": "ImprovementPlan",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "id",
            "description": "<p>提升和改善计划表id</p>"
          },
          {
            "group": "Parameter",
            "type": "bigint",
            "optional": false,
            "field": "report_item_id",
            "description": "<p>报告条目id</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "year",
            "description": "<p>年度</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "month",
            "description": "<p>月份</p>"
          },
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "ok",
            "description": "<p>完成情况</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "plan",
            "description": "<p>改善计划</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "remark",
            "description": "<p>备注</p>"
          },
          {
            "group": "Parameter",
            "type": "Timestamp",
            "optional": false,
            "field": "create_date",
            "description": "<p>创建时间</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request_Example:",
          "content": "{\n \"id\":1,\n \"report_item_id\":0,\n \"year\":\"2019\",\n \"month\":\"5\",\n \"ok\":1,\n \"plan\":\"1\",\n \"remark\":\"1\",\n \"create_date\":\"2019-01-01 00:00:00\"\n }\nPOST: /updateImprovementPlan\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
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
    "type": "DELETE",
    "url": "/deleteAllMonthReport",
    "title": "删除所有流动资金成本管控情况月度总结情况报告表信息",
    "name": "deleteAllMonthReport__________________________",
    "group": "MonthReport",
    "parameter": {
      "examples": [
        {
          "title": "Request_Example:",
          "content": "DELETE: /deleteAllMonthReport\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\n     \"code\":0,\n     \"message\":\"删除所有流动资金成本管控情况月度总结情况报告表成功\"\n}",
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
    "type": "DELETE",
    "url": "/deleteMonthReportById?id=",
    "title": "删除指定流动资金成本管控情况月度总结情况报告表信息",
    "name": "deleteMonthReportById__________________________",
    "group": "MonthReport",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "id",
            "description": "<p>指定 流动资金成本管控情况月度总结情况报告表记录id</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request_Example:",
          "content": "DELETE: /deleteMonthReportById?id=\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\n     \"code\":0,\n     \"message\":\"删除指定流动资金成本管控情况月度总结情况报告表成功\"\n}",
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
    "title": "查询所有流动资金成本管控情况月度总结情况报告表信息",
    "name": "getAllMonthReport__________________________",
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
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"查询所有流动资金成本管控情况月度总结情况报告表成功\",\"data\":\n[\n    {\n     \"id\":1,\n     \"report_item_id\":0,\n     \"year\":\"2019\",\n     \"month\":\"5\",\"\n     \"target\":1000.1,\n     \"value\":2000.1,\n     \"difference\":3000.1,\n     \"measure\":\"1111\",\n     \"experience\":\"111\",\n     \"deficiency\":\"111\",\n     \"evaluate\":\"111\",\n     \"remark\":\"111\",\n     \"create_date\":\"2019-01-01 00:00:00-01\"\n     },\n    {\n     \"id\":2,\n     \"report_item_id\":0,\n     \"year\":\"2019\",\n     \"month\":\"5\",\"\n     \"target\":1000.1,\n     \"value\":2000.1,\n     \"difference\":3000.1,\n     \"measure\":\"1111\",\n     \"experience\":\"111\",\n     \"deficiency\":\"111\",\n     \"evaluate\":\"111\",\n     \"remark\":\"111\",\n     \"create_date\":\"2019-01-01 00:00:00\"\n     }\n ]\n }",
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
    "type": "POST",
    "url": "/insertMonthReport",
    "title": "插入流动资金成本管控情况月度总结情况报告表信息",
    "name": "insertMonthReport__________________________",
    "group": "MonthReport",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "bigint",
            "optional": false,
            "field": "report_item_id",
            "description": "<p>报告条目id</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "year",
            "description": "<p>年度</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "month",
            "description": "<p>月份</p>"
          },
          {
            "group": "Parameter",
            "type": "BigDecimal",
            "optional": false,
            "field": "target",
            "description": "<p>目标值</p>"
          },
          {
            "group": "Parameter",
            "type": "BigDecimal",
            "optional": false,
            "field": "value",
            "description": "<p>末余额</p>"
          },
          {
            "group": "Parameter",
            "type": "BigDecimal",
            "optional": false,
            "field": "difference",
            "description": "<p>偏差值</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "measure",
            "description": "<p>本期主要管控措施</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "experience",
            "description": "<p>经验</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "deficiency",
            "description": "<p>不足</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "evaluate",
            "description": "<p>考核人评价</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "remark",
            "description": "<p>备注</p>"
          },
          {
            "group": "Parameter",
            "type": "Timestamp",
            "optional": false,
            "field": "create_date",
            "description": "<p>创建时间</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request_Example:",
          "content": "{\n\"report_item_id\":0,\n\"year\":\"2019\",\n\"month\":\"5\",\"\n\"target\":1000.1,\n\"value\":2000.1,\n\"difference\":3000.1,\n\"measure\":\"1111\",\n\"experience\":\"111\",\n\"deficiency\":\"111\",\n\"evaluate\":\"111\",\n\"remark\":\"111\",\n\"create_date\":\"2019-01-01 00:00:00\"\n }\nPOST: /insertMonthReport\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"插入流动资金成本管控情况月度总结情况报告表成功\"}",
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
    "title": "查询指定流动资金成本管控情况月度总结情况报告表信息",
    "name": "selectMonthReportById__________________________",
    "group": "MonthReport",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "id",
            "description": "<p>指定流动资金成本管控情况月度总结情况报告表记录id</p>"
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
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\n\"message\":\"查找指定流动资金成本管控情况月度总结情况报告表成功\",\n\"data\":\n{\"id\":1,\n\"report_item_id\":0,\n\"year\":\"2019\",\n\"month\":\"5\",\n\"ok\":1,\n\"plan\":\"1\",\n\"remark\":\"1\",\n\"create_date\":\"2019-01-01 00:00:00\"}\n}",
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
    "type": "PUT",
    "url": "/updateMonthReport",
    "title": "更新指定流动资金成本管控情况月度总结情况报告表信息",
    "name": "updateMonthReport__________________________",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "id",
            "description": "<p>流动资金成本管控情况月度总结情况报告表id</p>"
          },
          {
            "group": "Parameter",
            "type": "bigint",
            "optional": false,
            "field": "report_item_id",
            "description": "<p>报告条目id</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "year",
            "description": "<p>年度</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "month",
            "description": "<p>月份</p>"
          },
          {
            "group": "Parameter",
            "type": "BigDecimal",
            "optional": false,
            "field": "target",
            "description": "<p>目标值</p>"
          },
          {
            "group": "Parameter",
            "type": "BigDecimal",
            "optional": false,
            "field": "value",
            "description": "<p>末余额</p>"
          },
          {
            "group": "Parameter",
            "type": "BigDecimal",
            "optional": false,
            "field": "difference",
            "description": "<p>偏差值</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "measure",
            "description": "<p>本期主要管控措施</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "experience",
            "description": "<p>经验</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "deficiency",
            "description": "<p>不足</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "evaluate",
            "description": "<p>考核人评价</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "remark",
            "description": "<p>备注</p>"
          },
          {
            "group": "Parameter",
            "type": "Timestamp",
            "optional": false,
            "field": "create_date",
            "description": "<p>创建时间</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request_Example:",
          "content": "{\n\"id\":1,\n\"report_item_id\":0,\n\"year\":\"2019\",\n\"month\":\"5\",\"\n\"target\":1000.1,\n\"value\":2000.1,\n\"difference\":3000.1,\n\"measure\":\"1111\",\n\"experience\":\"111\",\n\"deficiency\":\"111\",\n\"evaluate\":\"111\",\n\"remark\":\"111\",\n\"create_date\":\"2019-01-01 00:00:00\"\n }\nPUT /updateMonthReport\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "group": "MonthReport",
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"更新流动资金成本管控情况月度总结情况报告表成功\"}",
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
    "type": "Post",
    "url": "/createValueCreation",
    "title": "插入流动资金占用成本管控增创价值表信息",
    "name": "createValueCreation____________________",
    "group": "ValueCreation",
    "parameter": {
      "examples": [
        {
          "title": "Request_Example:",
          "content": "{\n \"id\":3,\n \"reportItemId\":46,\n \"year\":2018,\n \"month\":7,\n \"lowerTarget\":27.0,\n \"totalLowerTarget\":36.1,\n \"realLowerTarget\":15.2,\n \"realTotalLowerTarget\":68.2,\n \"difference\":28.0,\n \"date\":\"2019-05-05\"\n}\nPOST: /createValueCreation\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"增加记录成功\",\"data\":true}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/ValueCreationController.java",
    "groupTitle": "ValueCreation",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/createValueCreation"
      }
    ]
  },
  {
    "type": "Delete",
    "url": "/deleteAllValueCreation",
    "title": "删除所有流动资金占用成本管控增创价值表信息",
    "name": "deleteAllValueCreation______________________",
    "group": "ValueCreation",
    "parameter": {
      "examples": [
        {
          "title": "Request_Example:",
          "content": "Delete: /deleteAllValueCreation\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"清空数据成功\",\"data\":true}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/ValueCreationController.java",
    "groupTitle": "ValueCreation",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/deleteAllValueCreation"
      }
    ]
  },
  {
    "type": "Delete",
    "url": "/deleteValueCreation?id=",
    "title": "删除指定流动资金占用成本管控增创价值表信息",
    "name": "deleteValueCreation______________________",
    "group": "ValueCreation",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "Integer",
            "optional": false,
            "field": "id",
            "description": "<p>指定要删除的流动资金占用成本管控增创价值表记录id</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request_Example:",
          "content": "Delete: /deleteValueCreation?id=\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"删除数据成功\",\"data\":true}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/ValueCreationController.java",
    "groupTitle": "ValueCreation",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/deleteValueCreation?id="
      }
    ]
  },
  {
    "type": "GET",
    "url": "/queryAllValueCreation",
    "title": "查询所有流动资金占用成本管控增创价值",
    "name": "queryAllValueCreation___________________",
    "group": "ValueCreation",
    "parameter": {
      "examples": [
        {
          "title": "Request_Example:",
          "content": "GET: /queryAllValueCreation\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n{\"code\": 0,\"message\": \"查询数据成功\",\"data\": [\n{id\": 1,\"reportItemId\": 1,\"year\": \"2018\",\"month\": \"9\",\"lowerTarget\": 74564,\n \"totalLowerTarget\": 311313,\"realLowerTarget\": 877878,\"realTotalLowerTarget\": 32323,\n \"difference\": 4545,date\": \"2019-05-06\" },\n{\"id\": 2,\"reportItemId\": 1,\"year\": \"2019\",\"month\": \"1\",\"lowerTarget\": 12121,\n \"totalLowerTarget\": 4545,\"realLowerTarget\": 45454,\"realTotalLowerTarget\": 87878,\n \"difference\": 542112,\"date\": \"2019-05-04\" }]\n}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/ValueCreationController.java",
    "groupTitle": "ValueCreation",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/queryAllValueCreation"
      }
    ]
  },
  {
    "type": "GET",
    "url": "/queryValueCreation?year=&month=",
    "title": "根据年月查询流动资金占用成本管控增创价值",
    "name": "queryValueCreation_____________________",
    "group": "ValueCreation",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "year",
            "description": "<p>指定流动资金占用成本管控增创价值表year值</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "month",
            "description": "<p>指定流动资金占用成本管控增创价值表month值</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request_Example:",
          "content": "GET: /queryValueCreation?year= & month=\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n{\"code\":0,\"message\":\"查询数据成功\",\"data\":[{\n\"id\":2,\"reportItemId\":1,\"year\":\"2019\",\"month\":\"1\",\"lowerTarget\":12121.0000,\"totalLowerTarget\":4545.0000,\n\"realLowerTarget\":45454.0000,\"realTotalLowerTarget\":87878.0000,\"difference\":542112.0000,\"date\":\"2019-05-04\"}]\n}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/ValueCreationController.java",
    "groupTitle": "ValueCreation",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/queryValueCreation?year=&month="
      }
    ]
  },
  {
    "type": "Put",
    "url": "/updateValueCreation",
    "title": "更新流动资金占用成本管控增创价值表信息",
    "name": "updateValueCreation____________________",
    "group": "ValueCreation",
    "parameter": {
      "examples": [
        {
          "title": "Request_Example:",
          "content": "{\n \"id\":1,\n \"reportItemId\":23,\n \"year\":2014,\n \"month\":5,\n \"lowerTarget\":25.0,\n \"totalLowerTarget\":16.1,\n \"realLowerTarget\":17.2,\n \"realTotalLowerTarget\":18.2,\n \"difference\":23.0,\n \"date\":\"2019-05-05\"\n}\nPUT: /updateValueCreation\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"修改数据成功\",\"data\":true}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/ValueCreationController.java",
    "groupTitle": "ValueCreation",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/updateValueCreation"
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
  }
] });
