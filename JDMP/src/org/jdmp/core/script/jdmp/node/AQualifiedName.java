/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.jdmp.core.script.jdmp.node;

import org.jdmp.core.script.jdmp.analysis.*;

@SuppressWarnings("nls")
public final class AQualifiedName extends PName
{
    private PName _name_;
    private TDot _dot_;
    private TIdentifier _identifier_;

    public AQualifiedName()
    {
        // Constructor
    }

    public AQualifiedName(
        @SuppressWarnings("hiding") PName _name_,
        @SuppressWarnings("hiding") TDot _dot_,
        @SuppressWarnings("hiding") TIdentifier _identifier_)
    {
        // Constructor
        setName(_name_);

        setDot(_dot_);

        setIdentifier(_identifier_);

    }

    @Override
    public Object clone()
    {
        return new AQualifiedName(
            cloneNode(this._name_),
            cloneNode(this._dot_),
            cloneNode(this._identifier_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAQualifiedName(this);
    }

    public PName getName()
    {
        return this._name_;
    }

    public void setName(PName node)
    {
        if(this._name_ != null)
        {
            this._name_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._name_ = node;
    }

    public TDot getDot()
    {
        return this._dot_;
    }

    public void setDot(TDot node)
    {
        if(this._dot_ != null)
        {
            this._dot_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._dot_ = node;
    }

    public TIdentifier getIdentifier()
    {
        return this._identifier_;
    }

    public void setIdentifier(TIdentifier node)
    {
        if(this._identifier_ != null)
        {
            this._identifier_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        this._identifier_ = node;
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._name_)
            + toString(this._dot_)
            + toString(this._identifier_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._name_ == child)
        {
            this._name_ = null;
            return;
        }

        if(this._dot_ == child)
        {
            this._dot_ = null;
            return;
        }

        if(this._identifier_ == child)
        {
            this._identifier_ = null;
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        if(this._name_ == oldChild)
        {
            setName((PName) newChild);
            return;
        }

        if(this._dot_ == oldChild)
        {
            setDot((TDot) newChild);
            return;
        }

        if(this._identifier_ == oldChild)
        {
            setIdentifier((TIdentifier) newChild);
            return;
        }

        throw new RuntimeException("Not a child.");
    }
}
