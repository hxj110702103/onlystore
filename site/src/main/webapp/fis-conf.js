fis.require('jello')(fis);

//map.json 生成路径配置
fis.match('{map.json,${namespace}-map.json}', {
    release: '/config/$0'
});

// 标记 staitc/libs 下面的 js 为模块化代码。
fis.match('/static/libs/**.js', {
    isMod: true,
    useHash: true
});

// 标记各功能页面下面的 js 为模块化代码。
fis.match('{page,widget}/**.js', {
    isMod: true,
    useHash: true
});

// jello 里面默认用的 commonjs 这里改成 amd 方案。
fis.unhook('commonjs');
fis.hook('amd', {
    packages: [
        // 用来存放 libs 库
        {
            name: 'libs',
            location: 'static/libs/',
            main: 'index'
        }
    ]
});

// 设置 *.scss 配置配置项
fis.match('*.scss', {
    useHash: true,
    rExt: '.css',
    parser: fis.plugin('node-sass', {
        include_paths: [
            './static/',
            './themes/',
            './page/'
        ]
    })
});

fis.match("{page,widget}/**.scss", {
    postprocessor: fis.plugin('px2rem', {
        baseDpr: 1,             // base device pixel ratio (default: 2)
        remVersion: true,       // whether to generate rem version (default: true)
        remUnit: 20,            // rem unit value (default: 75)
        remPrecision: 6
    })
});

//页面模板文件
fis.match('{page,widget}/**.{jsp,vm,html}', {
    isMod: true,
    url: '$0',
    release: '/views/$0'
});

fis.match('/{page,themes}/**.xml', {
    release: '/views/$0'
});

// 不启用 less
fis.match('*.less', {
    parser: null
});

// 解析 markdown，编译成 html
fis.match('*.md', {
    parser: fis.plugin('marked'),
    rExt: '.html'
});

//zip文件不构建
fis.match('*.zip', {
    release: false
});