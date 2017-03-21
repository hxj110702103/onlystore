
/**
 * Created by Auser on 2017/2/21.
 */
Ext.define('OnlyStore.model.account.Member', {
    extend: 'Ext.data.Model',

    fields: [
        {
            name: "id",
            type: "integer",
            allowNull: false,
            convert: null
        },
        {
            name: "memberName",
            type: "string",
            validators: [
                {
                    type: "length",
                    min: 0,
                    max: 18
                }
            ]
        },
        {
            name: "email",
            validators: [
                {
                    type: "email"
                },
                {
                    type: "length",
                    min: 0,
                    max: 64
                }
            ]
        },
        {
            name: "mobile"
        },
        {
            name: "password",
            validators: [
                {
                    type: "notBlank",
                    min: 6,
                    max: 18
                }
            ]
        },
        {
            name: "loginType",
            validators: [
                {
                    type: "notBlank"
                }
            ]
        },
        {
            name: "gradeId",
            type: "integer",
            allowNull: false
        },
        {
            name: "realName"
        },
        {
            name: "birthday",
            type: "date",
            dateFormat: 'Y-m-d H:i:s O'
        },
        {
            name: "sex"
        },
        {
            name: "regIp"
        },
        {
            name: "regTime",
            dateFormat: 'Y-m-d H:i:s O'
        },
        {
            name: "emailVerify",
            type: "boolean"
        },
        {
            name: "createTime",
            type: "date",
            dateFormat: 'Y-m-d H:i:s O',
            persist: false
        },
        {
            name: "updateTime",
            type: "date",
            dateFormat: 'Y-m-d H:i:s O',
            persist: false
        },
        {
            name: "totalPoint",
            type: "integer"
        },
        {
            name: "currentPoint",
            type: "integer"
        },
        {
            name: 'sourceChannel'
        },
        {
            name: 'sourceMemo',
            type: 'string'
        },
        {
            name: 'referrerName',
            type: 'string'
        },
        {
            name: 'parentRealName',
            type: 'string'
        },
        {
            name: 'parentId',
            type: 'integer'
        },
        {
            name: 'valid',
            type: 'boolean'
        }
    ],

    proxy: {
        type: 'direct',
        api: {
            read: 'memberAction.search'
        },
        reader: {
            rootProperty: 'records'
        }
    }
});