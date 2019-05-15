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
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"查询提升和改善计划表成功\",\n\"data\":[\n         {\n             \"id\":1,\n             \"report_item_id\":0,\n             \"year\":\"2019\",\n             \"month\":\"5\",\n             \"ok\":1,\n             \"plan\":\"1\",\n             \"remark\":\"1\",\n             \"create_date\":\"2019-01-01 00:00:00\"\n             \"item\":{\n                      \"item_code\"=\"短期投资\"\n                     \"item_name\"=\"短期投资\"\n                     \"calc_expr=\"1101-1102\"\n                     \"calc_explain\"=\"短期投资-短期投资跌价准备\"\n                     \"state\"=\"1\"\n                     \"modify_time\"= \"2019-04-28 09:59:00\"\n         }\n             },\n         {\n             \"id\":2,\n             \"report_item_id\":0,\n             \"year\":\"2019\",\n             \"month\":\"5\",\n             \"ok\":1,\n             \"plan\":\"1\",\n             \"remark\":\"1\",\n             \"create_date\":\"2019-01-01 00:00:00\"\n             \"item\":{\n                     \"item_code\"=\"短期投资\"\n                     \"item_name\"=\"短期投资\"\n                     \"calc_expr=\"1101-1102\"\n                     \"calc_explain\"=\"短期投资-短期投资跌价准备\"\n                     \"state\"=\"1\"\n                     \"modify_time\"= \"2019-04-28 09:59:00\"\n         }\n           }\n      ]}",
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
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\n\"message\":\"查找指定提升和改善计划表成功\",\n\"data\":{\"id\":1,\n\"report_item_id\":0,\n\"year\":\"2019\",\n\"month\":\"5\",\n\"ok\":1,\n\"plan\":\"1\",\n\"remark\":\"1\",\n\"create_date\":\"2019-01-01 00:00:00\"\n\"item\":{\n         \"item_code\"=\"短期投资\"\n         \"item_name\"=\"短期投资\"\n         \"calc_expr=\"1101-1102\"\n         \"calc_explain\"=\"短期投资-短期投资跌价准备\"\n         \"state\"=\"1\"\n         \"modify_time\"= \"2019-04-28 09:59:00\"\n         }\n}}",
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
    "type": "POST",
    "url": "/addIncentiveRatio",
    "title": "添加一条部门奖励比例成功",
    "name": "addIncentiveRatio_____________",
    "group": "IncentiveRatio",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "year",
            "description": "<p>年份（每年一月，设置）</p>"
          },
          {
            "group": "Parameter",
            "type": "BigDecimal",
            "optional": false,
            "field": "interest_rate",
            "description": "<p>利率</p>"
          },
          {
            "group": "Parameter",
            "type": "BigDecimal",
            "optional": false,
            "field": "incentive_ratio",
            "description": "<p>奖励比例</p>"
          },
          {
            "group": "Parameter",
            "type": "BigDecimal",
            "optional": false,
            "field": "max_limit",
            "description": "<p>大额资金限制</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request_Example:",
          "content": "{\n         \"year\":\"2019\",\n         \"interest_rate\":35.03,\n         \"incentive_ratio\":35.03,\n         \"max_limit\":35.03\n}\nPOST: /addIncentiveRatio\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"添加一条部门奖励比例成功\", \"data\":true}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/IncentiveRatioController.java",
    "groupTitle": "IncentiveRatio",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/addIncentiveRatio"
      }
    ]
  },
  {
    "type": "DELETE",
    "url": "/deleteIncentiveRatio?id=",
    "title": "删除指定部门奖励比例",
    "name": "deleteIncentiveRatio___________",
    "group": "IncentiveRatio",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "id",
            "description": "<p>指定部门奖励比例id</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request_Example:",
          "content": "DELETE: /deleteIncentiveRatio?id=\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"删除指定部门奖励比例成功\", \"data\":true}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/IncentiveRatioController.java",
    "groupTitle": "IncentiveRatio",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/deleteIncentiveRatio?id="
      }
    ]
  },
  {
    "type": "DELETE",
    "url": "/deleteIncentiveRatios",
    "title": "删除所有部门奖励比例",
    "name": "deleteIncentiveRatios___________",
    "group": "IncentiveRatio",
    "parameter": {
      "examples": [
        {
          "title": "Request_Example:",
          "content": "DELETE: /deleteIncentiveRatios\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"删除所有部门奖励比例成功\", \"data\":true}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/IncentiveRatioController.java",
    "groupTitle": "IncentiveRatio",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/deleteIncentiveRatios"
      }
    ]
  },
  {
    "type": "GET",
    "url": "/queryIncentiveRatio?id=",
    "title": "查询指定部门奖励比例",
    "name": "queryIncentiveRatio___________",
    "group": "IncentiveRatio",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "id",
            "description": "<p>指定部门奖励比例id</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request_Example:",
          "content": "GET: /queryIncentiveRatio?id=\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n(\"code\":0, \"message\":\"查询指定部门奖励比例成功\",\n\"data\":{\n         \"id\":200,\n         \"year\":\"2018\",\n         \"interest_rate\":15.01,\n         \"incentive_ratio\":15.01,\n         \"max_limit\":15.01,\n         \"create_date\":2019-05-08T11:20:12.000+0000\n}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/IncentiveRatioController.java",
    "groupTitle": "IncentiveRatio",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/queryIncentiveRatio?id="
      }
    ]
  },
  {
    "type": "GET",
    "url": "/queryIncentiveRatios",
    "title": "查询所有部门奖励比例",
    "name": "queryIncentiveRatios___________",
    "group": "IncentiveRatio",
    "parameter": {
      "examples": [
        {
          "title": "Request_Example:",
          "content": "GET: /queryIncentiveRatios\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n(\"code\":0, \"message\":\"查询所有部门奖励比例成功\",\n\"data\":[\n     {\n         \"id\":200,\n         \"year\":\"2018\",\n         \"interest_rate\":15.01,\n         \"incentive_ratio\":15.01,\n         \"max_limit\":15.01,\n         \"create_date\":2019-05-08T11:20:12.000+0000\n     },\n     {\n         \"id\":201,\n         \"year\":\"2019\",\n         \"interest_rate\":25.02,\n         \"incentive_ratio\":25.02,\n         \"max_limit\":25.02,\n         \"create_date\":2019-05-08T11:20:36.000+0000\n     }\n])",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/IncentiveRatioController.java",
    "groupTitle": "IncentiveRatio",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/queryIncentiveRatios"
      }
    ]
  },
  {
    "type": "PUT",
    "url": "/updateIncentiveRatio",
    "title": "更改指定部门奖励比例成功",
    "name": "updateIncentiveRatio_____________",
    "group": "IncentiveRatio",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "id",
            "description": "<p>指定部门奖励比例id</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "year",
            "description": "<p>年份（每年一月，设置）</p>"
          },
          {
            "group": "Parameter",
            "type": "BigDecimal",
            "optional": false,
            "field": "interest_rate",
            "description": "<p>利率</p>"
          },
          {
            "group": "Parameter",
            "type": "BigDecimal",
            "optional": false,
            "field": "incentive_ratio",
            "description": "<p>奖励比例</p>"
          },
          {
            "group": "Parameter",
            "type": "BigDecimal",
            "optional": false,
            "field": "max_limit",
            "description": "<p>大额资金限制</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request_Example:",
          "content": "{\n         \"id\":200,\n         \"year\":\"2019\",\n         \"interest_rate\":35.03,\n         \"incentive_ratio\":35.03,\n         \"max_limit\":35.03\n}\nPUT: /updateIncentiveRatio\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"更改指定部门奖励比例成功\", \"data\":true}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/IncentiveRatioController.java",
    "groupTitle": "IncentiveRatio",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/updateIncentiveRatio"
      }
    ]
  },
  {
    "type": "PUT",
    "url": "/updateIncentiveRatios",
    "title": "批量更改指定部门奖励比例成功",
    "name": "updateIncentiveRatios_______________",
    "group": "IncentiveRatio",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "id",
            "description": "<p>指定部门奖励比例id</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "year",
            "description": "<p>年份（每年一月，设置）</p>"
          },
          {
            "group": "Parameter",
            "type": "BigDecimal",
            "optional": false,
            "field": "interest_rate",
            "description": "<p>利率</p>"
          },
          {
            "group": "Parameter",
            "type": "BigDecimal",
            "optional": false,
            "field": "incentive_ratio",
            "description": "<p>奖励比例</p>"
          },
          {
            "group": "Parameter",
            "type": "BigDecimal",
            "optional": false,
            "field": "max_limit",
            "description": "<p>大额资金限制</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request_Example:",
          "content": "[\n     {\n         \"id\":200,\n         \"year\":\"2019\",\n         \"interest_rate\":35.03,\n         \"incentive_ratio\":35.03,\n         \"max_limit\":35.03\n     },\n     {\n         \"id\":201,\n         \"year\":\"2019\",\n         \"interest_rate\":45.04,\n         \"incentive_ratio\":45.04,\n         \"max_limit\":45.04\n     }\n]\nPUT: /updateIncentiveRatios\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"批量更改部门奖励比例成功\", \"data\":true}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/IncentiveRatioController.java",
    "groupTitle": "IncentiveRatio",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/updateIncentiveRatios"
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
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"查询所有流动资金成本管控情况月度总结情况报告表成功\",\"data\":\n[\n    {\n     \"id\":1,\n     \"report_item_id\":0,\n     \"year\":\"2019\",\n     \"month\":\"5\",\"\n     \"target\":1000.1,\n     \"value\":2000.1,\n     \"difference\":3000.1,\n     \"measure\":\"1111\",\n     \"experience\":\"111\",\n     \"deficiency\":\"111\",\n     \"evaluate\":\"111\",\n     \"remark\":\"111\",\n     \"create_date\":\"2019-01-01 00:00:00-01\"\n      \"item\":{\n                     \"item_code\"=\"短期投资\"\n                     \"item_name\"=\"短期投资\"\n                     \"calc_expr=\"1101-1102\"\n                     \"calc_explain\"=\"短期投资-短期投资跌价准备\"\n                     \"state\"=\"1\"\n                     \"modify_time\"= \"2019-04-28 09:59:00\"\n         }\n     },\n    {\n     \"id\":2,\n     \"report_item_id\":0,\n     \"year\":\"2019\",\n     \"month\":\"5\",\"\n     \"target\":1000.1,\n     \"value\":2000.1,\n     \"difference\":3000.1,\n     \"measure\":\"1111\",\n     \"experience\":\"111\",\n     \"deficiency\":\"111\",\n     \"evaluate\":\"111\",\n     \"remark\":\"111\",\n     \"create_date\":\"2019-01-01 00:00:00\"\n      \"item\":{\n                     \"item_code\"=\"短期投资\"\n                     \"item_name\"=\"短期投资\"\n                     \"calc_expr=\"1101-1102\"\n                     \"calc_explain\"=\"短期投资-短期投资跌价准备\"\n                     \"state\"=\"1\"\n                     \"modify_time\"= \"2019-04-28 09:59:00\"\n         }\n     }\n ]\n }",
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
    "url": "/monthReport",
    "title": "插入流动资金成本管控情况月度总结情况报告表信息",
    "name": "monthReport________________________",
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
          "content": "{\n\"report_item_id\":0,\n\"year\":\"2019\",\n\"month\":\"5\",\"\n\"target\":1000.1,\n\"value\":2000.1,\n\"difference\":3000.1,\n\"measure\":\"1111\",\n\"experience\":\"111\",\n\"deficiency\":\"111\",\n\"evaluate\":\"111\",\n\"remark\":\"111\",\n\"create_date\":\"2019-01-01 00:00:00\"\n }\nPOST: /monthReport\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
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
        "url": "http://oscm.xmiss.top/oscm_new/monthReport"
      }
    ]
  },
  {
    "type": "DELETE",
    "url": "/monthReport?id=",
    "title": "删除指定流动资金成本管控情况月度总结情况报告表信息",
    "name": "monthReport__________________________",
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
          "content": "DELETE: /monthReport?id=\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
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
        "url": "http://oscm.xmiss.top/oscm_new/monthReport?id="
      }
    ]
  },
  {
    "type": "PUT",
    "url": "/monthReport",
    "title": "更新指定流动资金成本管控情况月度总结情况报告表信息",
    "name": "monthReport__________________________",
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
          "content": "{\n\"id\":1,\n\"report_item_id\":0,\n\"year\":\"2019\",\n\"month\":\"5\",\"\n\"target\":1000.1,\n\"value\":2000.1,\n\"difference\":3000.1,\n\"measure\":\"1111\",\n\"experience\":\"111\",\n\"deficiency\":\"111\",\n\"evaluate\":\"111\",\n\"remark\":\"111\",\n\"create_date\":\"2019-01-01 00:00:00\"\n }\nPUT /monthReport\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
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
        "url": "http://oscm.xmiss.top/oscm_new/monthReport"
      }
    ]
  },
  {
    "type": "DELETE",
    "url": "/monthReports",
    "title": "删除所有流动资金成本管控情况月度总结情况报告表信息",
    "name": "monthReports__________________________",
    "group": "MonthReport",
    "parameter": {
      "examples": [
        {
          "title": "Request_Example:",
          "content": "DELETE: /monthReport\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
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
        "url": "http://oscm.xmiss.top/oscm_new/monthReports"
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
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\n\"message\":\"查找指定流动资金成本管控情况月度总结情况报告表成功\",\n\"data\":\n{    \"id\":1,\n     \"report_item_id\":0,\n     \"year\":\"2019\",\n     \"month\":\"5\",\n     \"ok\":1,\n     \"plan\":\"1\",\n     \"remark\":\"1\",\n     \"create_date\":\"2019-01-01 00:00:00\"\n      \"item\":{\n                     \"item_code\"=\"短期投资\"\n                     \"item_name\"=\"短期投资\"\n                     \"calc_expr=\"1101-1102\"\n                     \"calc_explain\"=\"短期投资-短期投资跌价准备\"\n                     \"state\"=\"1\"\n                     \"modify_time\"= \"2019-04-28 09:59:00\"\n         }\n}\n}",
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
    "type": "GET",
    "url": "/selectProportionAndReport?year=year&&month=month&&type=type",
    "title": "查询指定项目占比（资产和负债）",
    "name": "selectProportionAndReport_________",
    "group": "Proportion",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "year",
            "description": "<p>指定项目占比表年</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "month",
            "description": "<p>指定项目占比表月</p>"
          },
          {
            "group": "Parameter",
            "type": "Boolean",
            "optional": false,
            "field": "type",
            "description": "<p>查询指定项目占比（资产和负债）</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request_Example:",
          "content": "GET: /selectProportionAndReport?year=year&&month=month&&type=type\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"查找项目占比表成功\",\n\"data\":{}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/ProportionController.java",
    "groupTitle": "Proportion",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/selectProportionAndReport?year=year&&month=month&&type=type"
      }
    ]
  },
  {
    "type": "GET",
    "url": "/selectProportionById?id=",
    "title": "查询指定项目占比",
    "name": "selectProportionById_________",
    "group": "Proportion",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "id",
            "description": "<p>指定项目占比表记录id</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request_Example:",
          "content": "GET: /selectProportionById?id=\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"查找项目占比表成功\",\n\"data\":{\"id\":1,\"report_item_id\":0,\"year\":\"2019\",\"month\":\"5\",\"proportion\":0.0,\"accumulate_proportion\":\"1.0\",\"asset_or_debt\":\"0\",\"create_date\":\"2019-01\"}}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/ProportionController.java",
    "groupTitle": "Proportion",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/selectProportionById?id="
      }
    ]
  },
  {
    "type": "GET",
    "url": "/selectProportionByYearAndMonth?year=year&&month=month",
    "title": "查询指定项目占比",
    "name": "selectProportionById_________",
    "group": "Proportion",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "year",
            "description": "<p>指定项目占比表年</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "month",
            "description": "<p>指定项目占比表月</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request_Example:",
          "content": "GET: /selectProportionByYearAndMonth?year=&&month=\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"查找项目占比表成功\",\n\"data\":{\"id\":1,\"report_item_id\":0,\"year\":\"2019\",\"month\":\"5\",\"proportion\":0.0,\"accumulate_proportion\":\"1.0\",\"asset_or_debt\":\"0\",\"create_date\":\"2019-01\"}}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/ProportionController.java",
    "groupTitle": "Proportion",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/selectProportionByYearAndMonth?year=year&&month=month"
      }
    ]
  },
  {
    "type": "POST",
    "url": "/addReduceTarget",
    "title": "添加一条项目降低目标设置",
    "name": "addReduceTarget_____________",
    "group": "ReduceTarget",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "BigInteger",
            "optional": false,
            "field": "report_item_id",
            "description": "<p>报告条目id</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "year",
            "description": "<p>年份</p>"
          },
          {
            "group": "Parameter",
            "type": "Double",
            "optional": false,
            "field": "year_percent",
            "description": "<p>年度百分比，单位%</p>"
          },
          {
            "group": "Parameter",
            "type": "BigDecimal",
            "optional": false,
            "field": "year_value",
            "description": "<p>计算后的年目标值</p>"
          },
          {
            "group": "Parameter",
            "type": "BigDecimal",
            "optional": false,
            "field": "last_year_value",
            "description": "<p>去年实际降低额</p>"
          },
          {
            "group": "Parameter",
            "type": "Boolean",
            "optional": false,
            "field": "asset_or_debt",
            "description": "<p>资产或负债，0资产  1负债</p>"
          }
        ]
      },
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
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"添加一条项目降低目标设置\",\"data\":true}",
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
    "type": "DELETE",
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
          "content": "DELETE: /deleteReduceTarget?id=\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"根据id删除一条指定项目降低目标设置成功\",\"data\":true}",
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
    "type": "DELETE",
    "url": "/deleteReduceTargets",
    "title": "删除所有项目降低目标设置",
    "name": "deleteReduceTargets_____________",
    "group": "ReduceTarget",
    "parameter": {
      "examples": [
        {
          "title": "Request_Example:",
          "content": "DELETE: /deleteReduceTargets\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"删除所有项目降低目标设置\", \"data\":true}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/ReduceTargetController.java",
    "groupTitle": "ReduceTarget",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/deleteReduceTargets"
      }
    ]
  },
  {
    "type": "GET",
    "url": "/queryReduceTarget?id=",
    "title": "查询指定项目降低目标设置",
    "name": "queryReduceTarget_____________",
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
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"查询指定项目降低目标设置\",\n\"data\":{\"id\":208,\"report_item_id\":0,\"year\":\"\",\"year_percent\":0,\"year_value\":635184.75,\"last_year_value\":,\n  \"jan\":52932.062,\"feb\":52932.062,\"mar\":52932.062,\"apr\":52932.062,\"may\":52932.062,\"jun\":52932.062,\n  \"jul\":52932.062,\"aug\":52932.062,\"sept\":52932.062,\"oct\":52932.062,\"nov\":52932.062,\"dec\":52932.062,\n  \"asset_or_debt\":true}\n}",
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
    "group": "ReduceTarget",
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
          "content": "HTTP/1.1 200 OK\n{\"code\":0,\"message\":\"查询所有项目降低目标设置成功\",\"data\":[\n{\"id\":208,\"report_item_id\":0,\"year\":\"\",\"year_percent\":0,\"year_value\":635184.75,\"last_year_value\":,\n  \"jan\":52932.062,\"feb\":52932.062,\"mar\":52932.062,\"apr\":52932.062,\"may\":52932.062,\"jun\":52932.062,\n  \"jul\":52932.062,\"aug\":52932.062,\"sept\":52932.062,\"oct\":52932.062,\"nov\":52932.062,\"dec\":52932.062,\n  \"asset_or_debt\":true,\"create_date\":\"2019-05-06T09:46:35.000+0000\"},\n{\"id\":209,\"report_item_id\":0,\"year\":\"\",\"year_percent\":0,\"year_value\":1000,\"last_year_value\":,\n  \"jan\":83.3333,\"feb\":583.3333,\"mar\":83.3333,\"apr\":83.3333,\"may\":83.3333,\"jun\":83.3333,\n  \"jul\":83.3333,\"aug\":83.3333,\"sept\":83.3333,\"oct\":83.3333,\"nov\":83.3333,\"dec\":83.3333,\n  \"asset_or_debt\":true}]\n}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/ReduceTargetController.java",
    "groupTitle": "ReduceTarget",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/queryReduceTargets"
      }
    ]
  },
  {
    "type": "PUT",
    "url": "/updateReduceTarget",
    "title": "更改指定项目降低目标设置",
    "name": "updateReduceTarget_____________",
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
          },
          {
            "group": "Parameter",
            "type": "BigDecimal",
            "optional": false,
            "field": "year_value",
            "description": "<p>计算后的年目标值</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request_Example:",
          "content": "{\n\"id\":238,\n\"year_value\":635184.7500\n}\nPUT: /updateReduceTarget\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"更改指定项目降低目标设置\",\"data\":true}",
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
    "type": "PUT",
    "url": "/updateReduceTargets",
    "title": "批量更改项目降低目标设置",
    "name": "updateReduceTargets_____________",
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
          },
          {
            "group": "Parameter",
            "type": "BigDecimal",
            "optional": false,
            "field": "year_value",
            "description": "<p>计算后的年目标值</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request_Example:",
          "content": "[\n{\"id\":237,\"year_value\":5000},\n{\"id\":238,\"year_value\":5000},\n{\"id\":239,\"year_value\":5000}\n]\nPUT: /updateReduceTargets\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"批量更改项目降低目标设置成功\",\"data\":true}",
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
    "url": "/getAllReportItemInstance",
    "title": "查询所有reportItemInstance",
    "name": "getAllReportItemInstance___reportItemInstance__",
    "group": "ReportItemInstance",
    "parameter": {
      "examples": [
        {
          "title": "Request_Example:",
          "content": "GET: /getAllReportItemInstance\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"查找reportItemInstance表成功\",\n\"data\":{\"id\":1,\"report_item_id\":0,\"year\":\"2019\",\"month\":\"5\",\"proportion\":0.0,\"accumulate_proportion\":\"1.0\",\"asset_or_debt\":\"0\",\"create_date\":\"2019-01\"}}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/ReportItemInstanceMapperController.java",
    "groupTitle": "ReportItemInstance",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/getAllReportItemInstance"
      }
    ]
  },
  {
    "type": "GET",
    "url": "/selectReportItemInstanceByYearAndMonth",
    "title": "查询指定年月的reportItemInstance",
    "name": "selectReportItemInstanceByYearAndMonth___reportItemInstance__",
    "group": "ReportItemInstance",
    "parameter": {
      "examples": [
        {
          "title": "Request_Example:",
          "content": "GET: /getAllReportItemInstance\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"查找reportItemInstance表成功\",\n\"data\":{\"id\":1,\"report_item_id\":0,\"year\":\"2019\",\"month\":\"5\",\"proportion\":0.0,\"accumulate_proportion\":\"1.0\",\"asset_or_debt\":\"0\",\"create_date\":\"2019-01\"}}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/ReportItemInstanceMapperController.java",
    "groupTitle": "ReportItemInstance",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/selectReportItemInstanceByYearAndMonth"
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
    "type": "DELETE",
    "url": "/deleteAllProportion",
    "title": "删除所有项目占比表记录",
    "name": "deleteAllProportion____________",
    "group": "deleteAllProportion",
    "parameter": {
      "examples": [
        {
          "title": "Request_Example:",
          "content": "DELETE: /deleteAllProportion\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"删除所有项目占比表记录\"}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/ProportionController.java",
    "groupTitle": "deleteAllProportion",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/deleteAllProportion"
      }
    ]
  },
  {
    "type": "DELETE",
    "url": "/deleteProportionById",
    "title": "删除指定项目占比表记录",
    "name": "deleteImprovementPlanById____________",
    "group": "deleteProportionById",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "int",
            "optional": false,
            "field": "id",
            "description": "<p>删除指定项目占比表记录id</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request_Example:",
          "content": "DELETE: /deleteProportionById?id=1\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"删除指定项目占比表记录成功\"}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/ProportionController.java",
    "groupTitle": "deleteProportionById",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/deleteProportionById"
      }
    ]
  },
  {
    "type": "GET",
    "url": "/getAllProportion",
    "title": "查找所有项目占比表记录",
    "name": "getAllProportion____________",
    "group": "getAllProportion",
    "parameter": {
      "examples": [
        {
          "title": "Request_Example:",
          "content": "GET: /getAllProportion\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"查找所有项目占比表记录成功\",\n\"data\":[\n{\n\"id\":143,\n\"report_item_id\":0,\n\"year\":\"\",\n\"month\":\"\",\n\"proportion\":0.6196991,\n\"accumulate_proportion\":0.6196991,\n\"asset_or_debt\":0,\n\"create_date\":\"2019-01-01 00:00:00\"},\n{\n\"id\":146,\n\"report_item_id\":0,\n\"year\":\"\",\n\"month\":\"\",\n\"proportion\":0,\n\"accumulate_proportion\":0.75356704,\n\"asset_or_debt\":0,\n\"create_date\":\"2019-01-01 00:00:00\"\n}\n]}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/ProportionController.java",
    "groupTitle": "getAllProportion",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/getAllProportion"
      }
    ]
  },
  {
    "type": "POST",
    "url": "/insertProportion",
    "title": "插入项目占比表",
    "name": "insertProportion________",
    "group": "insertProportion",
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
            "type": "String",
            "optional": false,
            "field": "proportion",
            "description": "<p>比例</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "accumulate_proportion",
            "description": "<p>累计比例</p>"
          },
          {
            "group": "Parameter",
            "type": "Boolean",
            "optional": false,
            "field": "asset_or_debt",
            "description": "<p>资产或负债</p>"
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
          "content": "{\n\"report_item_id\":0,\n\"year\":\"\",\n\"month\":\"\",\n\"proportion\":0,\n\"accumulate_proportion\":0.75356704,\n\"asset_or_debt\":0,\n\"create_date\":\"2019-01-01 00:00:00\"\n}\nPOST: /insertImprovementPlan\n<p>\nRequest Header 如下\nContent-Type:application/json;charset=utf-8\nAuthorization:Bearer {jwt}\n<p>",
          "type": "json"
        }
      ]
    },
    "success": {
      "examples": [
        {
          "title": "Success-Response:",
          "content": "HTTP/1.1 200 OK\n<p>\n{\"code\":0,\"message\":\"插入项目占比表成功\"}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "java/edu/jmu/oscm/controller/ProportionController.java",
    "groupTitle": "insertProportion",
    "sampleRequest": [
      {
        "url": "http://oscm.xmiss.top/oscm_new/insertProportion"
      }
    ]
  }
] });
